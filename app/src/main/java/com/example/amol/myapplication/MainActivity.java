package com.example.amol.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private String response=null;
    public  TextView helloText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenConnection connectSocket=new OpenConnection(){
            public void onPostExecute(String r) {

                helloText = (TextView) findViewById(R.id.textView3);
                helloText.setText(result);
            }
        };
        connectSocket.execute();


    }

    public void displayMessage(View view){

    }

}
