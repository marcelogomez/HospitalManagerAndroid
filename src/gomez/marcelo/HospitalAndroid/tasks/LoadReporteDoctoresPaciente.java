package gomez.marcelo.HospitalAndroid.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import gomez.marcelo.HospitalAndroid.thrift.ServerInterface;
import gomez.marcelo.HospitalAndroid.thrift.gen.ReporteDoctoresPaciente;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 3:56 AM
 */
public class LoadReporteDoctoresPaciente extends AsyncTask<String, Void, ArrayList<ReporteDoctoresPaciente>> {
    // Debug variables
    private static final String LOG_TAG = "LoadReporteDoctoresPaciente";

    private OnCompletionListener<ArrayList<ReporteDoctoresPaciente>> onCompletionListener;
    private ServerInterface serverInterface;
    private ProgressDialog pDialog;
    private Context context;

    public LoadReporteDoctoresPaciente(Context context) {
        this.context = context;
    }

    public void setOnCompletionListener(OnCompletionListener<ArrayList<ReporteDoctoresPaciente>> onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
//        pDialog.show();
    }

    @Override
    protected ArrayList<ReporteDoctoresPaciente> doInBackground(String... params) {
        Log.d(LOG_TAG, "Entered doInBackground");

        ArrayList<ReporteDoctoresPaciente> reportes = null;
        serverInterface = new ServerInterface();
        try {
            // Open communications
            serverInterface.connect();
            reportes = new ArrayList<ReporteDoctoresPaciente>(serverInterface.getClient().generarReporteDoctoresPaciente(params[0]));
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
    protected void onPostExecute(ArrayList<ReporteDoctoresPaciente> reportes) {
        Log.d(LOG_TAG, "onPostExecute");
        if(onCompletionListener != null)
            onCompletionListener.onCompletion(reportes);
        pDialog.cancel();
    }
}
