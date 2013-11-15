package gomez.marcelo.HospitalAndroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import gomez.marcelo.HospitalAndroid.fragments.GridFragment;
import gomez.marcelo.HospitalAndroid.fragments.ListFragment;
import gomez.marcelo.HospitalAndroid.fragments.ReportesFragment;
import gomez.marcelo.HospitalAndroid.tasks.LoadAnalisisTask;
import gomez.marcelo.HospitalAndroid.tasks.LoadDoctoresTask;
import gomez.marcelo.HospitalAndroid.tasks.LoadPacientesTask;
import gomez.marcelo.HospitalAndroid.tasks.OnCompletionListener;
import gomez.marcelo.HospitalAndroid.thrift.gen.AnalisisClinico;
import gomez.marcelo.HospitalAndroid.thrift.gen.Doctor;
import gomez.marcelo.HospitalAndroid.thrift.gen.Paciente;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/11/13
 * Time: 8:06 PM
 */
public class MainActivity extends Activity {
    private static final String LOG_TAG = "MainActivity";

    private ListView               drawerList;
    private DrawerLayout           navDrawer;
    private String[]               options;
    private ArrayList<Doctor>      doctores;
    private ArrayList<Paciente>    pacientes;
    private GridFragment<Doctor> doctoresFragment;
    private GridFragment<Paciente> pacientesFragment;
    private ListFragment analisisFragment;
    private int                    currentOption = -1;
    private ActionBarDrawerToggle  abToggle;
    private ProgressBar            activityIndicator;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        options    = getResources().getStringArray(R.array.drawer_options);
        drawerList = (ListView)findViewById(R.id.left_drawer);
        navDrawer  = (DrawerLayout)findViewById(R.id.drawer_layout);
        activityIndicator = (ProgressBar)findViewById(R.id.progress_bar);

        abToggle    = new ActionBarDrawerToggle(this, navDrawer, R.drawable.ic_drawer, R.string.app_name, R.string.app_name);
        navDrawer.setDrawerListener(abToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);


//        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item,options));
        drawerList.setAdapter(new DrawerAdapter(this));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectDrawerItem(i);
            }
        });
        selectDrawerItem(0);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        abToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        abToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.refresh) {
            activityIndicator.setVisibility(View.VISIBLE);
            if(currentOption == 0)
                loadDoctores();
            else if(currentOption == 1)
                loadPacientes();
            else if(currentOption == 2)
                loadAnalisis();
        }
        if(abToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        switch (currentOption) {
            case 0:
                menu.findItem(R.id.search).setVisible(true);
                menu.findItem(R.id.refresh).setVisible(true);
                break;
            case 1:
                menu.findItem(R.id.search).setVisible(true);
                menu.findItem(R.id.refresh).setVisible(true);
                break;
            case 2:
                menu.findItem(R.id.search).setVisible(false);
                menu.findItem(R.id.refresh).setVisible(true);
                break;
            case 3:
                menu.findItem(R.id.search).setVisible(false);
                menu.findItem(R.id.refresh).setVisible(false);
                break;
        }

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView       = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                search(s);
                return false;
            }
        });

        return true;
    }

    private void selectDrawerItem(int i) {
        if(currentOption != i) {
            switch(i) {
                case 0: // Doctores
                    if(doctoresFragment == null)
                        loadDoctores();
                    else
                        putFragmentInContentFrame(doctoresFragment);
                    getActionBar().setIcon(R.drawable.doctores_white);
                    break;
                case 1: // Pacientes
                    if(pacientesFragment == null)
                        loadPacientes();
                    else
                        putFragmentInContentFrame(pacientesFragment);
                    getActionBar().setIcon(R.drawable.pacientes_white);
                    break;
                case 2: // Analisis
                    if(analisisFragment == null)
                        loadAnalisis();
                    else
                        putFragmentInContentFrame(analisisFragment);
                    getActionBar().setIcon(R.drawable.analisis_white);
                    break;
                case 3: // Reportes
                    putFragmentInContentFrame(new ReportesFragment());
                    getActionBar().setIcon(R.drawable.reportes_white);
                    break;
            }
            setTitle(options[i]);
            drawerList.setItemChecked(i,true);
            // Update flag
            currentOption = i;
            invalidateOptionsMenu();
        }
        navDrawer.closeDrawer(drawerList);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
        }
    }

    private void search(String query) {
        Log.d(LOG_TAG, "Searching query "+query);
        ArrayList<GridAdapter.GridItem> gridItems = new ArrayList<GridAdapter.GridItem>();
        switch (currentOption) {
            case 0:
                if(doctores == null)
                    break;
                gridItems = new ArrayList<GridAdapter.GridItem>();
                ArrayList<Doctor>               search    = new ArrayList<Doctor>();
                for(Doctor doctor : doctores) {
                    boolean isAMatch;

                    isAMatch = doctor.clave.equalsIgnoreCase(query);
                    if(!isAMatch)
                        isAMatch = doctor.nombre.toLowerCase().contains(query.toLowerCase());
                    if(!isAMatch)
                        isAMatch = doctor.especialidad.toLowerCase().contains(query.toLowerCase());

                    if(isAMatch) {
                        GridAdapter.GridItem item = new GridAdapter.GridItem(
                                doctor.getClave(),
                                getResources().getIdentifier(doctor.getClave().toLowerCase(),"drawable",getPackageName()),
                                doctor.getNombre());
                        item.especialidad = doctor.getEspecialidad();
                        gridItems.add(item);
                        search.add(doctor);
                    }
                }
                doctoresFragment.setGridItems(gridItems, search);
                break;
            case 1:
                if(pacientes == null)
                    break;
                gridItems = new ArrayList<GridAdapter.GridItem>();
                ArrayList<Paciente> search1  = new ArrayList<Paciente>();
                for(Paciente paciente : pacientes) {
                    boolean isAMatch;

                    isAMatch = paciente.clave.equalsIgnoreCase(query);
                    if(!isAMatch)
                        isAMatch = paciente.nombre.toLowerCase().contains(query.toLowerCase());

                    if(isAMatch) {
                        int id = getResources().getIdentifier(paciente.getClave().toLowerCase(),"drawable",getPackageName());
                        if(id == 0) id = R.drawable.placeholder_jpg;
                        GridAdapter.GridItem item = new GridAdapter.GridItem(paciente.getClave(),
                                id,
                                paciente.getNombre());
                        gridItems.add(item);
                        search1.add(paciente);
                    }
                }
                pacientesFragment.setGridItems(gridItems, search1);
                break;
        }
    }

    private void putFragmentInContentFrame(Fragment fragment) {
        new FragmentSwapper(getFragmentManager(),false).replaceWithoutBackStack(fragment, R.id.content_frame);
    }

    private void loadDoctores() {
        LoadDoctoresTask loadDoctoresTask = new LoadDoctoresTask(this);
        loadDoctoresTask.setOnCompletionListener(new OnCompletionListener<ArrayList<Doctor>>() {
            @Override
            public void onCompletion(ArrayList<Doctor> result) {
                onDoctoresResult(result);
            }
        });
        loadDoctoresTask.execute();
    }

    private void loadPacientes() {
        LoadPacientesTask loadPacientesTask = new LoadPacientesTask();
        loadPacientesTask.setOnCompletionListener(new OnCompletionListener<ArrayList<Paciente>>() {
            @Override
            public void onCompletion(ArrayList<Paciente> result) {
                onPacientesResult(result);
            }
        });
        loadPacientesTask.execute();
    }

    private void loadAnalisis() {
        LoadAnalisisTask loadAnalisisTask = new LoadAnalisisTask(this);
        loadAnalisisTask.setOnCompletionListener(new OnCompletionListener<ArrayList<AnalisisClinico>>() {
            @Override
            public void onCompletion(ArrayList<AnalisisClinico> result) {
                onAnalisisResult(result);
            }
        });
        loadAnalisisTask.execute();
    }

    private void onAnalisisResult(ArrayList<AnalisisClinico> result) {
        if(result == null) {
            Toast.makeText(this, "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(activityIndicator != null)
            activityIndicator.setVisibility(View.GONE);
        analisisFragment = new ListFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("analisis",(Serializable)result);
        analisisFragment.setArguments(arguments);
        putFragmentInContentFrame(analisisFragment);
    }

    private void onDoctoresResult(ArrayList<Doctor> doctores) {
        if(doctores == null) {
            Toast.makeText(this, "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(activityIndicator !=null)
            activityIndicator.setVisibility(View.GONE);
        Log.d(LOG_TAG,"onDoctoresResult");
        this.doctores = doctores;
        ArrayList<GridAdapter.GridItem> gridItems = new ArrayList<GridAdapter.GridItem>();
        for(Doctor doctor : doctores) {
            int id = getResources().getIdentifier(doctor.getClave().toLowerCase(),"drawable",getPackageName());
            if(id == 0) id = R.drawable.placeholder_jpg;
            GridAdapter.GridItem item = new GridAdapter.GridItem(
                    doctor.getClave(),
                    id,
                    doctor.getNombre());
            item.especialidad = doctor.getEspecialidad();
            gridItems.add(item);
        }
        // Setup fragment
        if(doctoresFragment == null) {
            doctoresFragment = new GridFragment<Doctor>();

            // Setup arguments for fragment
            Bundle arguments = new Bundle();
            arguments.putSerializable("object_items", doctores);
            arguments.putSerializable("grid_items"  , gridItems);
            doctoresFragment.setArguments(arguments);
        }
        else
            doctoresFragment.setGridItems(gridItems, doctores);
        putFragmentInContentFrame(doctoresFragment);
    }

    private void onPacientesResult(ArrayList<Paciente> pacientes) {
        if(pacientes == null) {
            Toast.makeText(this, "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(activityIndicator !=null)
            activityIndicator.setVisibility(View.GONE);
        Log.d(LOG_TAG,"onDoctoresResult");
        this.pacientes = pacientes;
        ArrayList<GridAdapter.GridItem> gridItems = new ArrayList<GridAdapter.GridItem>();
        for(Paciente paciente : pacientes) {
            int id = getResources().getIdentifier(paciente.getClave().toLowerCase(),"drawable",getPackageName());
            if(id == 0) id = R.drawable.placeholder_jpg;
            GridAdapter.GridItem item = new GridAdapter.GridItem(
                    paciente.getClave(),
                    id,
                    paciente.getNombre());
            gridItems.add(item);
        }
        // Setup fragment
        if(pacientesFragment == null) {
            pacientesFragment = new GridFragment<Paciente>();

            // Setup arguments for fragment
            Bundle arguments = new Bundle();
            arguments.putSerializable("object_items", pacientes);
            arguments.putSerializable("grid_items"  , gridItems);
            pacientesFragment.setArguments(arguments);
        }
        else
            pacientesFragment.setGridItems(gridItems, pacientes);
        putFragmentInContentFrame(pacientesFragment);
    }
}