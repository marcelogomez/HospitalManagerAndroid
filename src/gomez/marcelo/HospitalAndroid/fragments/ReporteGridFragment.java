package gomez.marcelo.HospitalAndroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import gomez.marcelo.HospitalAndroid.GridAdapter;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteDoctoresPaciente;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReportePacientesDoctor;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 3:37 AM
 */
public class ReporteGridFragment<R,G> extends Fragment {
    private GridFragment<G> gridFragment;
    private ReporteDoctoresPaciente report1;
    private ReportePacientesDoctor  report2;

    public ReporteGridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(gomez.marcelo.HospitalAndroid.R.layout.reporte_grid,null);
        ImageView picture  = (ImageView)view.findViewById(gomez.marcelo.HospitalAndroid.R.id.iv_reporte);
        TextView  tvNombre = (TextView)view.findViewById(gomez.marcelo.HospitalAndroid.R.id.tv_reporte_nombre);
        TextView tvClave   = (TextView)view.findViewById(gomez.marcelo.HospitalAndroid.R.id.tv_reporte_clave);

        gridFragment = new GridFragment<G>();
        R reporte = (R) getArguments().getSerializable("reporte");

        if(reporte instanceof ReporteDoctoresPaciente)
            report1 = (ReporteDoctoresPaciente)reporte;
        else
            report2 = (ReportePacientesDoctor)reporte;

        ArrayList<G> objectItems = (ArrayList<G>) getArguments().getSerializable("object_items");
        ArrayList<GridAdapter.GridItem> gridItems = (ArrayList<GridAdapter.GridItem>) getArguments().getSerializable("grid_items");
        Bundle arguments = new Bundle();
        arguments.putSerializable("object_items",objectItems);
        arguments.putSerializable("grid_items",gridItems);
        gridFragment.setArguments(arguments);

        getFragmentManager().beginTransaction().replace(gomez.marcelo.HospitalAndroid.R.id.reporte_grid_frame,gridFragment).commit();


        return view;
    }
}
