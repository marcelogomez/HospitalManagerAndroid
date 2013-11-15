package gomez.marcelo.HospitalAndroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import gomez.marcelo.HospitalAndroid.R;
import gomez.marcelo.HospitalAndroid.ReporteListAdapter;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteAnalisisPaciente;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteDoctoresPaciente;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReportePacientesAnalisis;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReportePacientesDoctor;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 1:50 PM
 */
public class ReporteListFragment<T> extends Fragment {
    private ListView  lv;
    private ImageView picture;
    private TextView  tvNombre;
    private TextView  tvClave;

    // Possible Arguments
    private ArrayList<ReportePacientesDoctor>   reportePacientesDoctor;
    private ArrayList<ReporteDoctoresPaciente>  reporteDoctoresPaciente;
    private ArrayList<ReportePacientesAnalisis> reportePacientesAnalisis;
    private ArrayList<ReporteAnalisisPaciente>  reporteAnalisisPaciente;

    public ReporteListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reporte_list, null);

        lv       = (ListView )view.findViewById(R.id.lv_reporte);
        picture  = (ImageView)view.findViewById(R.id.iv_reporte);
        tvNombre = (TextView )view.findViewById(R.id.tv_reporte_nombre);
        tvClave  = (TextView )view.findViewById(R.id.tv_reporte_clave);

        String clave  = getArguments().getString("clave");
        String nombre = getArguments().getString("nombre");
        int    picId  = getArguments().getInt("foto");
        ArrayList<ReporteListAdapter.ListItem> items = (ArrayList<ReporteListAdapter.ListItem>) getArguments().getSerializable("items");

        tvNombre.setText(clave);
        tvClave.setText(nombre);
        if(picId !=0)
            picture.setImageResource(picId);

        ReporteListAdapter adapter = new ReporteListAdapter(getActivity(),R.id.tv_clave,items.toArray(new ReporteListAdapter.ListItem[items.size()]));
        lv.setAdapter(adapter);

        return view;
    }
}
