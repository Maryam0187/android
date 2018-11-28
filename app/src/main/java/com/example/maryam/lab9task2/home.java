package com.example.maryam.lab9task2;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class home extends AppCompatActivity implements dialog.Dialoglis{

    Button fajrStatus,dhurstatus,asrstatus,magribstatus,ishastatus,btnweek;

    TextView tv,dhur,asr,magrib,isha;
    ImageButton share;
    dialog d;
    final Context context= this;
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DBHandler db=new DBHandler(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String a= dateFormat.format(date);
        Prayer pa=new Prayer("123","not Selected","not Selected","not Selected","not Selected","not Selected","123");
        pa.setToday(a);
        db.addPrayer(pa);
        Prayer p=db.setvalue();
        db.graphweek();

        btnweek=(Button) findViewById(R.id.weekBtn);
        fajrStatus=(Button)findViewById(R.id.FajarBtn);
        dhurstatus= (Button) findViewById(R.id.DhuharBtn);
        asrstatus=(Button) findViewById(R.id.AsarBtn);
        magribstatus=(Button) findViewById(R.id.MaghribBtn);
        ishastatus=(Button) findViewById(R.id.IshaBtn);
        dhur=(TextView) findViewById(R.id.dhuharStatus);
        asr=(TextView) findViewById(R.id.asarStatus);
        magrib=(TextView) findViewById(R.id.maghribStatus);
        isha=(TextView) findViewById(R.id.ishaStatus);
        tv=(TextView) findViewById(R.id.fajarStatus);
        tv.setText(p.Fajar);
        dhur.setText(p.Dhuhar);
        asr.setText(p.Asar);
        magrib.setText(p.Maghrib);
        isha.setText(p.Isha);


        final Bundle s= savedInstanceState;


        fajrStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=1;
                dialog d= new dialog();
                d.show(getSupportFragmentManager(),"example");
            }

        });

        dhurstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=2;
                dialog d= new dialog();
                d.show(getSupportFragmentManager(),"example");
            }

        });
        asrstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=3;
                dialog d= new dialog();
                d.show(getSupportFragmentManager(),"example");
            }

        });
        magribstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=4;
                dialog d= new dialog();
                d.show(getSupportFragmentManager(),"example");
            }

        });
        ishastatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=5;
                dialog d= new dialog();
                d.show(getSupportFragmentManager(),"example");
            }

        });
        share=(ImageButton)findViewById(R.id.shareBtn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        btnweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),weekgraph.class);
                startActivity(intent);


            }
        });
    }

    @Override
    public void applytext(String status) {

        if (check==1)
        {
            DBHandler db=new DBHandler(this);
            String a=db.update_status(FeedReaderContract.FeedEntry.Fajr_status,status);
            Log.v("hellooooooooo",a);
            tv.setText(status);
        }
        if (check==2)
        {
            DBHandler db=new DBHandler(this);
            String a=db.update_status(FeedReaderContract.FeedEntry.Dhur_status,status);
            dhur.setText(status);
        }
        if (check==3)
        {
            DBHandler db=new DBHandler(this);
            String a=db.update_status(FeedReaderContract.FeedEntry.Asr_status,status);
            asr.setText(status);
        }
        if (check==4)
        {
            DBHandler db=new DBHandler(this);
            String a=db.update_status(FeedReaderContract.FeedEntry.Magrib_status,status);
            magrib.setText(status);
        }
        if (check==5)
        {
            DBHandler db=new DBHandler(this);
            String a=db.update_status(FeedReaderContract.FeedEntry.Isha_status,status);
            isha.setText(status);
        }



    }
}
