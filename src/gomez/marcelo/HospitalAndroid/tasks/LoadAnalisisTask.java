package gomez.marcelo.HospitalAndroid.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import gomez.marcelo.HospitalAndroid.thrift.ServerInterface;
import gomez.marcelo.HospitalAndroid.thrift.gen.AnalisisClinico;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 2:49 AM
 */
public class LoadAnalisisTask extends AsyncTask<Void, Void, ArrayList<AnalisisClinico>> {
    // Debug variables
    private static final String LOG_TAG = "LoadDoctoresTask";

    private OnCompletionListener<ArrayList<AnalisisClinico>> onCompletionListener;
    private ServerInterface serverInterface;
    private Context context;

    public LoadAnalisisTask(Context context) {
        this.context = context;
    }

    public void setOnCompletionListener(OnCompletionListener<ArrayList<AnalisisClinico>> onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected ArrayList<AnalisisClinico> doInBackground(Void... voids) {
        Log.d(LOG_TAG, "Entered doInBackground");

        ArrayList<AnalisisClinico> analisisClinicos = null;
        serverInterface = new ServerInterface();
        try {
            // Open communications
            serverInterface.connect();
            analisisClinicos = new ArrayList<AnalisisClinico>(serverInterface.getClient().consultarAnalisis());
        }
        catch (Exception e) {
            Log.d(LOG_TAG, e.toString());
        }
        finally {
            // Close communications
            serverInterface.disconnect();
        }

        Log.d(LOG_TAG, "Finished doInBackground");
        return analisisClinicos;
    }

    @Override
    protected void onPostExecute(ArrayList<AnalisisClinico> analisisClinicos) {
        Log.d(LOG_TAG, "onPostExecute");
        if(onCompletionListener != null)
            onCompletionListener.onCompletion(analisisClinicos);
    }
}

