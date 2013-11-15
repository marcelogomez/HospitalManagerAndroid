package gomez.marcelo.HospitalAndroid.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import gomez.marcelo.HospitalAndroid.thrift.ServerInterface;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReportePacientesDoctor;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 5:10 AM
 */
public class LoadReportePacientesDoctor extends AsyncTask<String, Void, ArrayList<ReportePacientesDoctor>>  {
    // Debug variables
    private static final String LOG_TAG = "LoadReporteDoctoresPaciente";

    private OnCompletionListener<ArrayList<ReportePacientesDoctor>> onCompletionListener;
    private ServerInterface serverInterface;
    private ProgressDialog pDialog;
    private Context context;

    public LoadReportePacientesDoctor(Context context) {
        this.context = context;
    }

    public void setOnCompletionListener(OnCompletionListener<ArrayList<ReportePacientesDoctor>> onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected ArrayList<ReportePacientesDoctor> doInBackground(String... params) {
        Log.d(LOG_TAG, "Entered doInBackground");

        ArrayList<ReportePacientesDoctor> reportes = null;
        serverInterface = new ServerInterface();
        try {
            // Open communications with thrift server
            serverInterface.connect();
            reportes = new ArrayList<ReportePacientesDoctor>(serverInterface.getClient().generarReportePacientesDoctor(params[0]));
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
    protected void onPostExecute(ArrayList<ReportePacientesDoctor> reportes) {
        Log.d(LOG_TAG, "onPostExecute");
        if(onCompletionListener != null)
            onCompletionListener.onCompletion(reportes);
    }
}
