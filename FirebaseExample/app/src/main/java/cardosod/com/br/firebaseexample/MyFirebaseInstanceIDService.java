package cardosod.com.br.firebaseexample;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.firebase.client.Firebase;
import com.google.firebase.database.*;
import android.os.Build;

/**
 * Created by cardosod on 26/07/2016.
 */
//Class extending FirebaseInstanceIdService
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        //Getting registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Displaying token on logcat
        Log.d(TAG, "Refreshed token: " + refreshedToken);

    }

    private void sendRegistrationToServer(String token) {
        Firebase.setAndroidContext(this);

        Firebase ref = new Firebase("https://meetyournextmoto-b9daf.firebaseio.com/");

        ref.child("Serial number").child(Build.SERIAL).setValue("teste@gmail.com");
        ref.child("Serial number").child("NADL456724").setValue("teste2@gmail.com");

        //You can implement this method to store the token on your server
        //Not required for current project
    }
}
