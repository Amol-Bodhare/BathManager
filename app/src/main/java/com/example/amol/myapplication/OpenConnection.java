package com.example.amol.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OpenConnection extends AsyncTask<String,String,String> {
    public int x;
    public String result=null;
    private String line=null;
    static String response=null;
    static Socket s1 = null;
    static BufferedReader br = null;
    static BufferedReader is = null;
    static PrintWriter os = null;
    protected String doInBackground(String... params) {
// this is where you implement your long-running task
        return connect();
    }



    public String connect() {

        //InetAddress address=InetAddress.getLocalHost();



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
                //line=br.readLine();
            ex();
            //response=is.readLine();
            //publishProgress(response);
            Log.w("Second response is",response);
            // return result;






        }
        catch(IOException e){
            e.printStackTrace();
            result="Error in GET DATA";
            System.out.println("Socket read Error");
        }
        //Log.w("THE RESPONSE IS--------------------->",this.result);
        return result;

    }
    public void refresh(){
        try{


            os.println("refresh");
            os.flush();
            response=is.readLine();
            publishProgress(response);
//            if(Boolean.parseBoolean(response))
//                System.out.println("The bathroom is vacant");
//            else
//                System.out.println("The bathroom is engaged");





        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Socket read Error");
        }
    }
    public void ex(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                refresh();
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 3000;
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay,
                intevalPeriod);
    }
}
