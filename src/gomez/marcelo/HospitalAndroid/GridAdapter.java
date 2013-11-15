package gomez.marcelo.HospitalAndroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/10/13
 * Time: 12:40 PM
 */
public class GridAdapter  extends BaseAdapter {
    // Debug variables
    private static final String LOG_TAG = "GridAdapter";
    private Context        context;
    private List<GridItem> items;

    // Contains the name and picture to be displayed in the grid
    public static class GridItem  implements Serializable {
        public int    pictureId;
        public String name;
        public String clave;
        public String especialidad;

        public GridItem(String clave, int pictureId,String name) {
            this.pictureId = pictureId;
            this.name      = name;
            this.clave     = clave;
        }
    }
    // Holder for the views inside each of the grid elements
    private class ViewHolder {
        TextView  name;
        ImageView picture;
    }

    // Constructor
    public GridAdapter(Context context, List<GridItem> items) {
        this.context = context;
        this.items   = items;
    }

    // Getters and setters
    public List<GridItem> getItems() {
        return items;
    }

    public void setItems(List<GridItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    // Overridden methods
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder     holder;

        // Check if view needs to be instantiated or if we can recycle it
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, null);

            holder         = new ViewHolder();
            holder.name    = (TextView)  convertView.findViewById(R.id.tv_name);
            holder.picture = (ImageView) convertView.findViewById(R.id.iv_grid);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        holder.name.setText(items.get(i).name);
//        Bitmap m_d = BitmapFactory.decodeResource(context.getResources(), items.get(i).pictureId);
//        if (m_d != null) {
//            Bitmap resizedBitmap = Bitmap.createScaledBitmap(m_d, 200, 200, true);
//            holder.picture.setImageBitmap(resizedBitmap);
//        }
        new ImageLoaderTask(holder.picture).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, items.get(i).pictureId);

        // Set holder as the tag for this view
        convertView.setTag(holder);

        return convertView;
    }

    private class ImageLoaderTask extends AsyncTask<Integer, Void, Bitmap> {
        private WeakReference<ImageView> imageViewWeakReference;
        private int id = 0;

        private ImageLoaderTask(ImageView imageView) {
            imageViewWeakReference = new WeakReference<ImageView>(imageView);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            id = integers[0];
            Bitmap bitmap = BitmapFactory.decodeResource(GridAdapter.this.context.getResources(), id);
            if(bitmap != null)
                bitmap =  Bitmap.createScaledBitmap(bitmap, 200, 200, true);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewWeakReference != null && bitmap != null) {
                final ImageView imageView = imageViewWeakReference.get();
                if (imageView != null)
                    imageView.setImageBitmap(bitmap);
            }

        }
    }
}
