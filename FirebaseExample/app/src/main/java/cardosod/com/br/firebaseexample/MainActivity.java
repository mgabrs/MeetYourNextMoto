package cardosod.com.br.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.util.Log;
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

        //dynamic menu
        final RadioGroup group = (RadioGroup) findViewById(R.id.rgTerms);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId){
                RadioButton button = (RadioButton) group.findViewById(checkedId);
            }
        });

        MyFirebaseInstanceIDService service = new MyFirebaseInstanceIDService();
        //service.sendRegistrationToServer();

        Firebase ref = new Firebase("https://meetyournextmoto-b9daf.firebaseio.com/");

        //Log.d("Pramesh: ", service.getToken());
        ref.child("Serial number").child(Build.SERIAL).setValue(service.getToken());

        Button orderButton = (Button)findViewById(R.id.testButton);

        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SuggestionActivity.class);
                startActivity(intent);
            }

        });
    }

    //OnCheckedChanged onCheckedChanged = new OnCheckedChanged() {
    OnCheckedChangeListener onCheckedChanged = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rbAgree:
                    TextView TextName = (TextView) findViewById(R.id.tvName);
                    TextName.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }
    };
}


