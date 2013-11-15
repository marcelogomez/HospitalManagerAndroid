package gomez.marcelo.HospitalAndroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import gomez.marcelo.HospitalAndroid.ListAdapter;
import gomez.marcelo.HospitalAndroid.R;
import gomez.marcelo.HospitalAndroid.thrift.gen.AnalisisClinico;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 2:34 AM
 */
public class ListFragment extends Fragment {

    ListView lv;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,null);

        ArrayList<AnalisisClinico> items = (ArrayList<AnalisisClinico>)getArguments().getSerializable("analisis");
        ListView lv = (ListView)view.findViewById(R.id.listview);
        lv.setAdapter(new ListAdapter(getActivity(), R.id.tv_clave,items.toArray(new AnalisisClinico[items.size()])));



        return view;
    }
}
