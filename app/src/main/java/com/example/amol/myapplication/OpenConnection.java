package com.example.amol.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class OpenConnection extends AsyncTask<String,Void,String> {
    public int x;
    public String result=null;
    private String line=null;
    private String response=null;
    protected String doInBackground(String... params) {
// this is where you implement your long-running task
        return connect();
    }


    public String connect() {

        //InetAddress address=InetAddress.getLocalHost();

        Socket s1 = null;
        BufferedReader br = null;
        BufferedReader is = null;
        PrintWriter os = null;

        try {
            s1 = new Socket("10.0.0.18", 4445); // You can use static final constant PORT_NUM
            br = new BufferedReader(new InputStreamReader(System.in));
            is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os = new PrintWriter(s1.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            Log.w("Socket Exception",e);
        }


        try{
            line="Ping";

                System.out.println("Message sent "+line);
                os.println(line);
                os.flush();
                response=is.readLine();
                Log.w("response 1 ",response);

                if(Boolean.parseBoolean(response))
                    result= "The bathroom is vacant";
                else
                    result= "The bathroom is engaged";
                line=br.readLine();





        }
        catch(IOException e){
            e.printStackTrace();
            result="Error in GET DATA";
            System.out.println("Socket read Error");
        }
        //Log.w("THE RESPONSE IS--------------------->",this.result);
        return result;

    }
}
