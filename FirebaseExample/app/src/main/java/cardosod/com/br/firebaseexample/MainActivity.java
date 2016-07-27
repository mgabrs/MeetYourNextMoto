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

        TextView textView = (TextView)findViewById(R.id.textView2);

        Firebase ref = new Firebase("https://meetyournextmoto-b9daf.firebaseio.com/");

        ref.child("Serial number").child(Build.SERIAL).setValue("teste@gmail.com");
        ref.child("Serial number").child("NADL456724").setValue("teste2@gmail.com");
    }
}


