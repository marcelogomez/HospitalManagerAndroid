package gomez.marcelo.HospitalAndroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import gomez.marcelo.HospitalAndroid.R;
import gomez.marcelo.HospitalAndroid.thrift.gen.Doctor;
import gomez.marcelo.HospitalAndroid.thrift.gen.Paciente;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 12:27 AM
 */

public class ProfileFragment extends Fragment {
    private Doctor   doctor = null;
    private Paciente paciente = null;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout,null);
        TextView tvClave             = (TextView)view.findViewById(R.id.tv_clave);
        TextView tvNombre            = (TextView)view.findViewById(R.id.tv_nombre);
        TextView tvEspecialidad      = (TextView)view.findViewById(R.id.tv_especialidad);
        TextView tvEspecialidadField = (TextView)view.findViewById(R.id.tv_especialidad_field);
        TextView tvDireccion         = (TextView)view.findViewById(R.id.tv_direccion);
        TextView tvTelefono          = (TextView)view.findViewById(R.id.tv_telefono);
        ImageView ivProfile          = (ImageView)view.findViewById(R.id.iv_profile);
        int resId;

        doctor = (Doctor)getArguments().getSerializable("doctor");
        if(doctor == null) {
            tvEspecialidad.setVisibility(View.GONE);
            tvEspecialidadField.setVisibility(View.GONE);

            paciente = (Paciente)getArguments().getSerializable("paciente");

            tvClave.setText(paciente.getClave());
            tvNombre.setText(paciente.getNombre());
            tvDireccion.setText(paciente.getDireccion());
            tvTelefono.setText(paciente.getTelefono());

            resId = getResources().getIdentifier(paciente.getClave().toLowerCase(), "drawable", getActivity().getPackageName());
        }
        else {
            tvClave.setText(doctor.getClave());
            tvNombre.setText(doctor.getNombre());
            tvEspecialidad.setText(doctor.getEspecialidad());
            tvDireccion.setText(doctor.getDireccion());
            tvTelefono.setText(doctor.getTelefono());

            resId = getResources().getIdentifier(doctor.getClave().toLowerCase(), "drawable", getActivity().getPackageName());
        }
        if(resId != 0)
            ivProfile.setImageResource(resId);


        return view;
    }
}
