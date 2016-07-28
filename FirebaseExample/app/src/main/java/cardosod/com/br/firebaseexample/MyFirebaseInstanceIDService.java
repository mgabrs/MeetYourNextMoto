package cardosod.com.br.firebaseexample;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by cardosod on 26/07/2016.
 */
//Class extending FirebaseInstanceIdService
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";
    String refreshedToken;

    @Override
    public void onTokenRefresh() {

        //Getting registration token
        refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Displaying token on logcat
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        //You can implement this method to store the token on your server
        //Not required for current project
    }

    public String getToken(){
        return FirebaseInstanceId.getInstance().getToken();
    }



}
