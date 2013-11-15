package gomez.marcelo.HospitalAndroid.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import gomez.marcelo.HospitalAndroid.thrift.ServerInterface;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteAnalisisPaciente;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 3:53 PM
 */
public class LoadReporteAnalisisPacienteTask extends AsyncTask<String, Void, ArrayList<ReporteAnalisisPaciente>> {
    // Debug variables
    private static final String LOG_TAG = "LoadReporteAnalisisPacienteTask";

    private OnCompletionListener<ArrayList<ReporteAnalisisPaciente>> onCompletionListener;
    private ServerInterface serverInterface;
    private ProgressDialog pDialog;
    private Context context;

    public LoadReporteAnalisisPacienteTask(Context context) {
        this.context = context;
    }

    public void setOnCompletionListener(OnCompletionListener<ArrayList<ReporteAnalisisPaciente>> onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
//        pDialog.show();
    }

    @Override
    protected ArrayList<ReporteAnalisisPaciente> doInBackground(String... params) {
        Log.d(LOG_TAG, "Entered doInBackground");

        ArrayList<ReporteAnalisisPaciente> reportes = null;
        serverInterface = new ServerInterface();
        try {
            // Open communications
            serverInterface.connect();
            reportes = new ArrayList<ReporteAnalisisPaciente>(serverInterface.getClient().generarReporteAnalisisPaciente(params[0]));
        }
        catch (Exception e) {
            Log.d(LOG_TAG, e.toString());
        }
        finally {
            // Close communications
            serverInterface.disconnect();
        }

        Log.d(LOG_TAG, "Finished doInBackground");
        return reportes;
    }

    @Override
    protected void onPostExecute(ArrayList<ReporteAnalisisPaciente> reportes) {
        Log.d(LOG_TAG, "onPostExecute");
        if(onCompletionListener != null)
            onCompletionListener.onCompletion(reportes);
        pDialog.cancel();
    }
}
