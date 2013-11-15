package gomez.marcelo.HospitalAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import gomez.marcelo.HospitalAndroid.thrift.gen.AnalisisClinico;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 2:36 AM
 */
public class ListAdapter extends ArrayAdapter<AnalisisClinico> {

    private AnalisisClinico[] items;
    private Context context;

    public ListAdapter(Context context, int textViewResourceId, AnalisisClinico[] objects) {
        super(context, textViewResourceId, objects);
        items = objects;
        this.context = context;
    }

    private class ViewHolder {
        TextView tvClave;
        TextView tvTipo;
        TextView tvDescripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);

            holder = new ViewHolder();
            holder.tvClave       = (TextView)view.findViewById(R.id.tv_clave_analisis);
            holder.tvTipo        = (TextView)view.findViewById(R.id.tv_tipo_analisis);
            holder.tvDescripcion = (TextView)view.findViewById(R.id.tv_descripcion_analisis);
        }
        else {
            view = convertView;
            holder = (ViewHolder)view.getTag();
        }

        holder.tvClave.setText(items[position].getClave()+":");
        holder.tvTipo.setText(items[position].getTipo());
        holder.tvDescripcion.setText(items[position].getDescripcion());
        view.setTag(holder);

        return view;
    }
}
