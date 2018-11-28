package com.example.maryam.lab9task2;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class splashscreen extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splashscreen);
        sp=getPreferences(MODE_PRIVATE);
        ed=sp.edit();

        //SharedPreferences.Editor ed=sp.edit();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (MainActivity.signin==true)
                {
                    ed.putString("sign","yes");
                    ed.commit();
                    Log.d("--->>",sp.getString("sign","hello"));
                }

                if (sp.getString("sign","").equals("yes"))
                {
                    Intent mainIntent = new Intent(splashscreen.this,home.class);
                    splashscreen.this.startActivity(mainIntent);
                    splashscreen.this.finish();
                }

                else
                {
                    Intent mainIntent = new Intent(splashscreen.this,MainActivity.class);
                    splashscreen.this.startActivity(mainIntent);
                    splashscreen.this.finish();

                }
                /* Create an Intent that will start the Menu-Activity. */
//
//
//
//                 if (MainActivity.signin==true)
//                {
//                    Intent mainIntent = new Intent(splashscreen.this,home.class);
//                    splashscreen.this.startActivity(mainIntent);
//                    splashscreen.this.finish();
//                }
//                else
//                {
//                    Intent mainIntent = new Intent(splashscreen.this,MainActivity.class);
//                    splashscreen.this.startActivity(mainIntent);
//                    splashscreen.this.finish();
//                }
//
//                    Intent mainIntent = new Intent(splashscreen.this,home.class);
//                    splashscreen.this.startActivity(mainIntent);
//                    splashscreen.this.finish();


            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}