package cardosod.com.br.firebaseexample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.text.Layout;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.view.*;
import android.widget.RadioGroup.*;
import android.widget.Button;
import android.content.Intent;
import com.firebase.client.Firebase;
import com.google.firebase.database.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add information button
        final Button orderButton = (Button)findViewById(R.id.buttonConf);

        //reject button
        final Button exitButton = (Button)findViewById(R.id.jasonButton);

        //dynamic menu
        RadioGroup group = (RadioGroup) findViewById(R.id.rgTerms);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId){

                int radioButtonID = group.getCheckedRadioButtonId();
                View radioButton = group.findViewById(radioButtonID);
                int idx = group.indexOfChild(radioButton);

                RelativeLayout layout = (RelativeLayout) findViewById(R.id.layoutMagic);

                switch (idx) {
                    case 0:
                        layout.setVisibility(View.VISIBLE);
                        exitButton.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        layout.setVisibility(View.INVISIBLE);
                        exitButton.setVisibility(View.VISIBLE);
                    default:
                        break;
                }
            }
        });

        MyFirebaseInstanceIDService service = new MyFirebaseInstanceIDService();
        //service.sendRegistrationToServer();

        Firebase ref = new Firebase("https://meetyournextmoto-b9daf.firebaseio.com/");

        //Log.d("Pramesh: ", service.getToken());
        ref.child("Serial number").child(Build.SERIAL).setValue(service.getToken());



        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SuggestionActivity.class);
                startActivity(intent);
            }

        });

        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               finish();
            }

        });

    }

}


