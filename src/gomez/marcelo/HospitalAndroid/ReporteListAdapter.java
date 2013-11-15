package gomez.marcelo.HospitalAndroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 2:04 PM
 */
public class ReporteListAdapter extends ArrayAdapter<ReporteListAdapter.ListItem>{

    private ListItem[] items;
    private Context    context;

    public static class ListItem {
        public int    pictureId;
        public String text;

        public ListItem(int pictureId, String text) {
            this.pictureId = pictureId;
            this.text = text;
        }
    }

    public ReporteListAdapter(Context context, int textViewResourceId, ListItem[] items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.items   = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        TextView  tvTexto;
        ImageView ivFoto;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.reporte_list_item,null);
        }
        else
            view = convertView;

        tvTexto = (TextView) view.findViewById(R.id.tv_reporte_texto);
        ivFoto  = (ImageView) view.findViewById(R.id.iv_reporte_foto);

        tvTexto.setText(items[position].text);

        Bitmap m_d = BitmapFactory.decodeResource(context.getResources(), items[position].pictureId);
        if (m_d != null) {
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(m_d, 120, 120, true);
            ivFoto.setImageBitmap(resizedBitmap);
        }

        return view;
    }
}
