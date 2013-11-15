package gomez.marcelo.HospitalAndroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import gomez.marcelo.HospitalAndroid.FragmentSwapper;
import gomez.marcelo.HospitalAndroid.GridAdapter;
import gomez.marcelo.HospitalAndroid.R;
import gomez.marcelo.HospitalAndroid.thrift.gen.Doctor;
import gomez.marcelo.HospitalAndroid.thrift.gen.Paciente;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/11/13
 * Time: 7:20 PM
 */
public class GridFragment<T> extends Fragment {
    // Debug variables
    private static final String LOG_TAG = "GridFragment";

    private ArrayList<T>                    objectItems;
    private ArrayList<GridAdapter.GridItem> gridItems;
    private GridAdapter                     adapter;
    private GridView                        grid;

    // Empty constructor required by Fragment class
    public GridFragment() {
        Log.d(LOG_TAG,"Entered Constructor");
        Log.d(LOG_TAG,"Finished Constructor");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_TAG,"Entered onCreateView");

        View view = inflater.inflate(R.layout.image_grid,null);

        // Get items from calling activity
        objectItems = (ArrayList<T>)getArguments().getSerializable("object_items");
        gridItems   = (ArrayList<GridAdapter.GridItem>)getArguments().getSerializable("grid_items");

        // Setup GridView
        grid        = (GridView)view.findViewById(R.id.gridview);
        adapter     = new GridAdapter(getActivity(),gridItems);
        grid.setAdapter(adapter);

        // Setup grid items to redirect to profile actvity
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG,"OnItemClick - Name "+gridItems.get(i).name);

                // Put profile fragment on top
                ProfileFragment profileFragment = new ProfileFragment();
                Bundle arguments = new Bundle();

                // Setup argument according to T
                if(objectItems.get(i) instanceof Doctor)
                    arguments.putSerializable("doctor",(Serializable)objectItems.get(i));
                else if(objectItems.get(i) instanceof Paciente)
                    arguments.putSerializable("paciente",(Serializable)objectItems.get(i));
                profileFragment.setArguments(arguments);
                // Put fragment on top
//                FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
//                transaction.add(R.id.content_frame,profileFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
                new FragmentSwapper(getFragmentManager(),false).replaceWithBackStack(profileFragment, R.id.content_frame);
            }
        });
        Log.d(LOG_TAG,"Finished onCreateView");
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        int count = grid.getCount();
        for (int i = 0; i < count; i++) {
            View v = grid.getChildAt(i);
            if(v != null) {
                ImageView iv = (ImageView) (v.findViewById(R.id.iv_grid));
                if (v != null)
                    if (iv.getDrawable() != null) iv.getDrawable().setCallback(null);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(objectItems.get(0) != null)
            if (objectItems.get(0) instanceof Doctor)
                getActivity().setTitle("Doctores");
            else
                getActivity().setTitle("Pacientes");
    }

    public void setGridItems(ArrayList<GridAdapter.GridItem> gridItems, ArrayList<T> objectItems) {
        this.gridItems   = gridItems;
        this.objectItems = objectItems;
        adapter.setItems(gridItems);
    }
}
