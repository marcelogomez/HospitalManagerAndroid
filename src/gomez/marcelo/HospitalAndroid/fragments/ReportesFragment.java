package gomez.marcelo.HospitalAndroid.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import gomez.marcelo.HospitalAndroid.FragmentSwapper;
import gomez.marcelo.HospitalAndroid.R;
import gomez.marcelo.HospitalAndroid.ReporteListAdapter;
import gomez.marcelo.HospitalAndroid.tasks.*;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteAnalisisPaciente;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteDoctoresPaciente;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReportePacientesAnalisis;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReportePacientesDoctor;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/10/13
 * Time: 12:15 PM
 */
public class ReportesFragment extends Fragment implements View.OnClickListener {

    public ReportesFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.reportes_layout, container, false);

        View reporteDoctoresPaciente  = rootView.findViewById(R.id.rl_reporte_doctores_paciente);
        View reportePacientesDoctor   = rootView.findViewById(R.id.rl_reporte_pacientes_doctor);
        View reporteAnalisisPaciente  = rootView.findViewById(R.id.rl_reporte_analisis_paciente);
        View reportePacientesAnalisis = rootView.findViewById(R.id.rl_reporte_pacientes_analisis);

        reporteAnalisisPaciente.setOnClickListener(this);
        reporteDoctoresPaciente.setOnClickListener(this);
        reportePacientesAnalisis.setOnClickListener(this);
        reportePacientesDoctor.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.reporte_dialog);
        dialog.setCancelable(false);

        String message = null;
        String title = null;
        // Choose which message to display
        switch (view.getId()){
            case R.id.rl_reporte_analisis_paciente:
                title = "Análisis Paciente";
                message = "Proporcionar clave del paciente: ";
                break;
            case R.id.rl_reporte_doctores_paciente:
                title = "Doctores Paciente";
                message = "Proporcionar clave del paciente: ";
                break;
            case R.id.rl_reporte_pacientes_analisis:
                title = "Pacientes Análisis";
                message = "Proporcionar clave del análisis:";
                break;
            case R.id.rl_reporte_pacientes_doctor:
                title = "Pacientes Doctor";
                message = "Proporcionar clave del doctor:";
                break;
        }
        dialog.setTitle(title);


        // Setup UI elementes
        TextView tvMessage = (TextView) dialog.findViewById(R.id.dialog_message);
        tvMessage.setText(message);
        final EditText etClave   = (EditText)dialog.findViewById(R.id.tf_dialog);
        etClave.requestFocus();
        Button cancel = (Button)dialog.findViewById(R.id.b_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        Button generar = (Button)dialog.findViewById(R.id.b_generar);
        final String mTitle = title;
        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etClave.getText().toString() == null || etClave.getText().toString().equals(""))
                    Toast.makeText(getActivity(),"Debes ingresar una clave",Toast.LENGTH_LONG).show();
                else {
                    dialog.dismiss();
                    if(mTitle.equalsIgnoreCase("doctores paciente")) {
                        LoadReporteDoctoresPaciente task = new LoadReporteDoctoresPaciente(getActivity());
                        task.setOnCompletionListener(new OnCompletionListener<ArrayList<ReporteDoctoresPaciente>>() {
                            @Override
                            public void onCompletion(ArrayList<ReporteDoctoresPaciente> result) {
                                onReporteDoctoresPaciente(result);
                            }
                        });
                        task.execute(etClave.getText().toString());
                    }
                    else if(mTitle.equalsIgnoreCase("pacientes doctor")) {
                        LoadReportePacientesDoctor task = new LoadReportePacientesDoctor(getActivity());
                        task.setOnCompletionListener(new OnCompletionListener<ArrayList<ReportePacientesDoctor>>() {
                            @Override
                            public void onCompletion(ArrayList<ReportePacientesDoctor> result) {
                                onReportePacientesDoctor(result);
                            }
                        });
                        task.execute(etClave.getText().toString());
                    }
                    else if(mTitle.equalsIgnoreCase("análisis paciente")) {
                        LoadReporteAnalisisPacienteTask task = new LoadReporteAnalisisPacienteTask(getActivity());
                        task.setOnCompletionListener(new OnCompletionListener<ArrayList<ReporteAnalisisPaciente>>() {
                            @Override
                            public void onCompletion(ArrayList<ReporteAnalisisPaciente> result) {
                                onReporteAnalisisPaciente(result);
                            }
                        });
                        task.execute(etClave.getText().toString());
                    }
                    else if(mTitle.equalsIgnoreCase("pacientes análisis")) {
                        LoadReportePacientesAnalsisTask task = new LoadReportePacientesAnalsisTask(getActivity());
                        task.setOnCompletionListener(new OnCompletionListener<ArrayList<ReportePacientesAnalisis>>() {
                            @Override
                            public void onCompletion(ArrayList<ReportePacientesAnalisis> result) {
                                onReportePacientesAnalisis(result);
                            }
                        });
                        task.execute(etClave.getText().toString());

                    }
                }
            }
        });
        dialog.show();
    }

    private void onReportePacientesAnalisis(ArrayList<ReportePacientesAnalisis> result) {
        if(result == null)
            Toast.makeText(getActivity(), "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
        else if(result.size() == 0)
            Toast.makeText(getActivity(), "No se encontraron coincidencias.", Toast.LENGTH_SHORT).show();
        else {
            FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
            ReporteListFragment<ReporteDoctoresPaciente> fragment = new ReporteListFragment<ReporteDoctoresPaciente>();

            ArrayList<ReporteListAdapter.ListItem> listItems = new ArrayList<ReporteListAdapter.ListItem>();
            for(ReportePacientesAnalisis report : result)
                listItems.add(
                        new ReporteListAdapter.ListItem(
                                getResources().getIdentifier(
                                        report.getClavePaciente().toLowerCase(),
                                        "drawable",
                                        getActivity().getPackageName()),
                                        "Paciente: "         + report.getNombrePaciente() + " | " +
                                        "Fecha Aplicación: " + report.getFechaAplica()    + " | " +
                                        "Fecha Entrega: "    + report.getFechaentrega()   + " | "));

            Bundle arguments = new Bundle();
            arguments.putSerializable("items", listItems);
            arguments.putString("clave", "Análisis " + result.get(0).getClaveAnalisis());
            arguments.putString("nombre", "Tipo: "+result.get(0).getTipo()+" | Descripción "+result.get(0).getDescripcion());
            arguments.putInt("foto", R.drawable.analisis_placeholder);
            fragment.setArguments(arguments);
            new FragmentSwapper(getFragmentManager(),false).replaceWithBackStack(fragment, R.id.content_frame);
        }
    }

    private void onReporteAnalisisPaciente(ArrayList<ReporteAnalisisPaciente> result) {
        if(result == null)
            Toast.makeText(getActivity(), "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
        else if(result.size() == 0)
            Toast.makeText(getActivity(), "No se encontraron coincidencias.", Toast.LENGTH_SHORT).show();
        else {
            FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
            ReporteListFragment<ReporteDoctoresPaciente> fragment = new ReporteListFragment<ReporteDoctoresPaciente>();

            ArrayList<ReporteListAdapter.ListItem> listItems = new ArrayList<ReporteListAdapter.ListItem>();
            for(ReporteAnalisisPaciente report : result)
                listItems.add(
                        new ReporteListAdapter.ListItem(
                                        R.drawable.analisis_placeholder,
                                        "Análisis: "         + report.getTipo()         + " | " +
                                        "Descripción: "      + report.getDescripcion()  + " | " +
                                        "Fecha Aplicación: " + report.getFechaAplic()   + " | " +
                                        "Fecha Entrega: "    + report.getFechaentrega() + " | "));

            Bundle arguments = new Bundle();
            arguments.putSerializable("items", listItems);
            arguments.putString("clave" , "Paciente "+result.get(0).getClavePaciente());
            arguments.putString("nombre", result.get(1).getNombrePaciente());
            arguments.putInt("foto"     , getResources().getIdentifier(
                    result.get(0).getClavePaciente().toLowerCase(),
                    "drawable",
                    getActivity().getPackageName()));
            fragment.setArguments(arguments);

            new FragmentSwapper(getFragmentManager(),false).replaceWithBackStack(fragment, R.id.content_frame);
        }
    }

    private void onReportePacientesDoctor(ArrayList<ReportePacientesDoctor> result) {
        if(result == null)
            Toast.makeText(getActivity(), "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
        else if(result.size() == 0)
            Toast.makeText(getActivity(), "No se encontraron coincidencias.", Toast.LENGTH_SHORT).show();
        else {
            FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
            ReporteListFragment<ReporteDoctoresPaciente> fragment = new ReporteListFragment<ReporteDoctoresPaciente>();

            ArrayList<ReporteListAdapter.ListItem> listItems = new ArrayList<ReporteListAdapter.ListItem>();
            for(ReportePacientesDoctor report : result)
                listItems.add(
                        new ReporteListAdapter.ListItem(
                                getResources().getIdentifier(
                                        report.getClavePaciente().toLowerCase(),
                                        "drawable",
                                        getActivity().getPackageName()),
                                "Paciente: "    + report.getNombrePaciente() + " | " +
                                "Tratamiento: " + report.getTratamiento()    + " | " +
                                "Diagnóstico: " + report.getDiagnostico()    + " | " +
                                "Fecha: "       + report.getFecha()          + " | "));

            Bundle arguments = new Bundle();
            arguments.putSerializable("items", listItems);
            arguments.putString("clave", "Doctor " + result.get(0).getClaveDoctor());
            arguments.putString("nombre",result.get(0).getNombreDoctor());
            arguments.putInt("foto", getResources().getIdentifier(
                    result.get(0).getClaveDoctor().toLowerCase(),
                    "drawable",
                    getActivity().getPackageName()));
            fragment.setArguments(arguments);
            new FragmentSwapper(getFragmentManager(),false).replaceWithBackStack(fragment, R.id.content_frame);
        }
    }

    private void onReporteDoctoresPaciente(ArrayList<ReporteDoctoresPaciente> result) {
        if(result == null)
            Toast.makeText(getActivity(), "Hubo un error al conectarse al servidor.", Toast.LENGTH_SHORT).show();
         else if(result.size() == 0)
            Toast.makeText(getActivity(), "No se encontraron coincidencias.", Toast.LENGTH_SHORT).show();
        else {
            FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
            ReporteListFragment<ReporteDoctoresPaciente> fragment = new ReporteListFragment<ReporteDoctoresPaciente>();

            ArrayList<ReporteListAdapter.ListItem> listItems = new ArrayList<ReporteListAdapter.ListItem>();
            for(ReporteDoctoresPaciente report : result)
                listItems.add(
                        new ReporteListAdapter.ListItem(
                                getResources().getIdentifier(
                                        report.getClaveDoctor().toLowerCase(),
                                        "drawable",
                                        getActivity().getPackageName()),
                                "Doctor: "      + report.getNombreDoctor() + " | " +
                                "Tratamiento: " + report.getTratamiento()  + " | " +
                                "Diagnóstico: " + report.getDiagnostico()  + " | " +
                                "Fecha: "       + report.getFecha()        + " | "));

            Bundle arguments = new Bundle();
            arguments.putSerializable("items", listItems);
            arguments.putString("clave" , "Paciente "+result.get(0).getClavePaciente());
            arguments.putString("nombre", result.get(0).getNombrePaciente());
            arguments.putInt("foto"     , getResources().getIdentifier(
                    result.get(0).getClavePaciente().toLowerCase(),
                    "drawable",
                    getActivity().getPackageName()));
            fragment.setArguments(arguments);
            new FragmentSwapper(getFragmentManager(),false).replaceWithBackStack(fragment, R.id.content_frame);
        }
    }
}
