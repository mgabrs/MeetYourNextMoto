package cardosod.com.br.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFirebaseInstanceIDService service = new MyFirebaseInstanceIDService();
        //service.sendRegistrationToServer();

        Firebase ref = new Firebase("https://meetyournextmoto-b9daf.firebaseio.com/");

        Log.d("Pramesh: ", service.getToken());
        ref.child("Serial number").child(Build.SERIAL).setValue(service.getToken());
    }
}


