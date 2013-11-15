package gomez.marcelo.HospitalAndroid.tasks;

import android.os.AsyncTask;
import android.util.Log;
import gomez.marcelo.HospitalAndroid.thrift.ServerInterface;
import gomez.marcelo.HospitalAndroid.thrift.gen.Paciente;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/11/13
 * Time: 9:42 PM
 */
public class LoadPacientesTask extends AsyncTask<Void, Void, ArrayList<Paciente>> {
    // Debug variables
    private static final String LOG_TAG = "LoadPacientesTask";

    private OnCompletionListener<ArrayList<Paciente>> onCompletionListener;
    private ServerInterface serverInterface;

    public LoadPacientesTask() {
    }

    public void setOnCompletionListener(OnCompletionListener<ArrayList<Paciente>> onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected ArrayList<Paciente> doInBackground(Void... voids) {
        Log.d(LOG_TAG, "Entered doInBackground");

        ArrayList<Paciente> doctors = null;
        serverInterface = new ServerInterface();
        try {
            // Open communications
            serverInterface.connect();
            doctors = new ArrayList<Paciente>(serverInterface.getClient().consultarPacientes());
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
    protected void onPostExecute(ArrayList<Paciente> pacientes) {
        Log.d(LOG_TAG, "onPostExecute");
        if(onCompletionListener != null)
            onCompletionListener.onCompletion(pacientes);
    }
}

