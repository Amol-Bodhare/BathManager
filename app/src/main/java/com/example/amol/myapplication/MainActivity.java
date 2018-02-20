package com.example.amol.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenConnection connect=new OpenConnection();
        //final TextView helloText = (TextView) findViewById(R.id.textView);
       // helloText.setText("Hey There");
    }

    public void displayMessage(View view){
        final TextView helloText = (TextView) findViewById(R.id.textView3);
        helloText.setText("Hey There");
    }
}
