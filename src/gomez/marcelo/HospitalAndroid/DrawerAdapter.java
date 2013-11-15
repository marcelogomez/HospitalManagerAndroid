package gomez.marcelo.HospitalAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 11:45 PM
 */
public class DrawerAdapter extends BaseAdapter {

    private Context context;
    private String[] text;

    public DrawerAdapter(Context context) {
        this.context = context;
        text = context.getResources().getStringArray(R.array.drawer_options);
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int i) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_list_item,null);
        }

        TextView tv = (TextView)view.findViewById(android.R.id.text1);
        tv.setText(text[i]);
        ImageView iv = (ImageView)view.findViewById(R.id.drawer_icon);
        switch (i) {
            case  0:
                iv.setImageResource(R.drawable.doctores_white);
                break;
            case 1:
                iv.setImageResource(R.drawable.pacientes_white);
                break;
            case 2:
                iv.setImageResource(R.drawable.analisis_white);
                break;
            case 3:
                iv.setImageResource(R.drawable.reportes_white);
                break;
        }

        return view;
    }
}
