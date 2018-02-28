package com.example.amol.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private String response=null;
    public  TextView helloText;
    public  TextView helloText1;

    Timer timer=new Timer();//Used for a delay to provide user feedback

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenConnection connectSocket=new OpenConnection(){
            public void onPostExecute(String r) {
//                displayMessage(result);


            }
            public void onProgressUpdate(String... values) {

                Log.w("onProgressUpdate",values[0]);

                displayMessage(values[0]);

            }

        };



        connectSocket.execute();
        Switch onOffSwitch = (Switch)  findViewById(R.id.switch1);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", ""+isChecked);
            }

        });

    }

    public void displayMessage(String res){


        helloText1 = (TextView) findViewById(R.id.textView3);
        Log.w("Res =========", res);
        if(Boolean.parseBoolean(res))
            helloText1.setText("The Bathroom is Vacant");
        else
            helloText1.setText("The Bathroom is Engaged");







    }

}
