package com.ce.nutchakhun.running;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;

import java.util.logging.LogRecord;


/**
 * Created by Nutchakhun on 10/13/15 AD.
 */


public class splashScreen extends Activity{
    private android.os.Handler myhandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        android.os.Handler myhandler = new android.os.Handler();
        myhandler.postDelayed(new Runnable(){

            @Override
            public void run() {
                finish();




                    Intent goMain = new Intent(getApplicationContext(), Main.class);
                    startActivity(goMain);


            }

        },3000);


    }



}




