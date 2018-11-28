package com.example.maryam.lab9task2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper{

    private static  final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="pray.db";

    public DBHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.Table_name);
        String CREATE_Prayer="CREATE TABLE "+FeedReaderContract.FeedEntry.Table_name+
                "(" +FeedReaderContract.FeedEntry._ID + " TEXT ,"+
                FeedReaderContract.FeedEntry.Fajr_status + " TEXT,"+
                FeedReaderContract.FeedEntry.Dhur_status+" TEXT,"+
                FeedReaderContract.FeedEntry.Asr_status+" TEXT,"+
                FeedReaderContract.FeedEntry.Magrib_status+" TEXT,"+
                FeedReaderContract.FeedEntry.Isha_status+ " TEXT,"+
                FeedReaderContract.FeedEntry.today_date+ " TEXT PRIMARY KEY " + " )";
        Log.v("query",CREATE_Prayer);
        db.execSQL(CREATE_Prayer);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("query1","updating");
        db.execSQL("DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.Table_name);
    }
    void addPrayer(Prayer p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(FeedReaderContract.FeedEntry._ID,p.id);
        values.put(FeedReaderContract.FeedEntry.Fajr_status,p.getFajar());
        values.put(FeedReaderContract.FeedEntry.Dhur_status,p.getDhuhar());
        values.put(FeedReaderContract.FeedEntry.Asr_status,p.getAsar());
        values.put(FeedReaderContract.FeedEntry.Magrib_status,p.getMaghrib());
        values.put(FeedReaderContract.FeedEntry.Isha_status,p.getIsha());
        values.put(FeedReaderContract.FeedEntry.today_date,p.getToday());
        db.insert(FeedReaderContract.FeedEntry.Table_name,null,values);
        db.close();
    }
    String update_status(String name,String status)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(name,status);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String b= dateFormat.format(date);
        Log.v("date",b);
        db.update(FeedReaderContract.FeedEntry.Table_name,cv,FeedReaderContract.FeedEntry.today_date +"= ?",new String[]{b});
        db=this.getReadableDatabase();
        Cursor c=db.rawQuery("Select "+name+" from "+FeedReaderContract.FeedEntry.Table_name,null);
        String a="";
        if(c.moveToFirst())
        {
            do {
                a=a+c.getString(0);

            }
            while (c.moveToNext());
        }

        return a;


    }

    Prayer  setvalue()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String a= dateFormat.format(date);
        Prayer courseList = new Prayer();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+FeedReaderContract.FeedEntry.Table_name + " WHERE " + FeedReaderContract.FeedEntry.today_date +"= ?", new String[] {a});

        if (c.moveToFirst())
        {
            do{
                Prayer contant=new Prayer();
                contant.id=c.getString(0);
                contant.Fajar=c.getString(1);
                contant.Dhuhar=c.getString(2);
                contant.Asar=c.getString(3);
                contant.Maghrib=c.getString(4);
                contant.Isha=c.getString(5);
                contant.today=c.getString(6);
                courseList=contant;
                Log.v("date----",contant.today);
                Log.v("fajr",contant.Fajar);


            }
            while (c.moveToNext());
        }
        return courseList;
    }

    ArrayList<Integer> graphweek()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] fajr=new String[7];
        String[] Dhur=new String[7];
        String[] Asar=new String[7];
        String[] Magrib=new String[7];
        String[] Asha=new String[7];

        Cursor c=db.rawQuery("Select * from "+FeedReaderContract.FeedEntry.Table_name ,null);
        int i=0;
        int f=0;
        int d=0;
        int a=0;
        int m=0;
        int is=0;
        if(c.moveToFirst())
        {
            do {
                fajr[i]=c.getString(1);
                Dhur[i]=c.getString(2);
                Asar[i]=c.getString(3);
                Magrib[i]=c.getString(4);
                Asha[i]=c.getString(5);
                Log.v("statusf",fajr[i]);
                Log.v("statusd",Dhur[i]);
                Log.v("statusa",Asar[i]);
                Log.v("statusm",Magrib[i]);
                Log.v("statusi",Asha[i]);
                if (fajr[i].equals("On Time"))
                {
                    f=f+1;
                }
                if (Magrib[i].equals("On Time"))
                {
                    m=m+1;
                }
                if (Dhur[i].equals("On Time"))
                {
                    d=d+1;
                }
                if (Asar[i].equals("On Time"))
                {
                    a=a+1;
                }
                if (Asha[i].equals("On Time"))
                {
                    is=is+1;
                }
            }

            while (c.moveToNext());
        }

      ArrayList<Integer> list=new ArrayList<>();
        list.add(f);
        list.add(d);
        list.add(a);
        list.add(m);
        list.add(is);
        return list;
    }



    }
