package gomez.marcelo.HospitalAndroid.tasks;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/11/13
 * Time: 8:55 PM
 */

// Interface for getting the result of an asynchronous task
public interface OnCompletionListener<T> {
    public void onCompletion(T result);
}
