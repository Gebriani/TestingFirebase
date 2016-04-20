package usingfirebase.orcaella.com.testingfirebase.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

/**
 * Created by gebriani on 20/04/16.
 */
public class BaseActivity extends AppCompatActivity {

    Firebase mRef;
    Firebase mRefChildUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRef = new Firebase("https://scorching-torch-6715.firebaseio.com/");
        mRefChildUser = mRef.child("users");
    }
}
