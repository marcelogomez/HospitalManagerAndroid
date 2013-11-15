package gomez.marcelo.HospitalAndroid.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import gomez.marcelo.HospitalAndroid.thrift.ServerInterface;
import gomez.marcelo.HospitalAndroid.thrift.gen.Doctor;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/11/13
 * Time: 8:51 PM
 */
public class LoadDoctoresTask extends AsyncTask<Void, Void, ArrayList<Doctor>> {
    // Debug variables
    private static final String LOG_TAG = "LoadDoctoresTask";

    private OnCompletionListener<ArrayList<Doctor>> onCompletionListener;
    private ServerInterface serverInterface;
    private ProgressDialog  pDialog;
    private Context         context;

    public LoadDoctoresTask(Context context) {
        this.context = context;
    }

    public void setOnCompletionListener(OnCompletionListener<ArrayList<Doctor>> onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
//        pDialog.show();
    }

    @Override
    protected ArrayList<Doctor> doInBackground(Void... voids) {
        Log.d(LOG_TAG, "Entered doInBackground");

        ArrayList<Doctor> doctors = null;
        serverInterface = new ServerInterface();
        try {
            // Open communications
            serverInterface.connect();
            doctors = new ArrayList<Doctor>(serverInterface.getClient().consultarDoctores());
        }
        catch (Exception e) {
            Log.d(LOG_TAG, e.toString());
        }
        finally {
            // Close communications
            serverInterface.disconnect();
        }

        Log.d(LOG_TAG, "Finished doInBackground");
        return doctors;
    }

    @Override
    protected void onPostExecute(ArrayList<Doctor> doctors) {
        Log.d(LOG_TAG, "onPostExecute");
        if(onCompletionListener != null)
            onCompletionListener.onCompletion(doctors);
        pDialog.cancel();
    }
}
