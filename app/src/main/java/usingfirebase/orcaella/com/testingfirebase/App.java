package usingfirebase.orcaella.com.testingfirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by gebriani on 20/04/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
