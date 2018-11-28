package com.example.maryam.lab9task2;

import android.provider.BaseColumns;

public class FeedReaderContract {

    private FeedReaderContract() {
    }

    public static class FeedEntry implements BaseColumns
    {
        public static final String Table_name="Prayer";
        public static final String Fajr_status="fajr";
        public static final String Dhur_status="dhur";
        public static final String Asr_status="asr";
        public static final String Magrib_status="magrib";
        public static final String Isha_status="isha";
        public static final String today_date="today";
    }

}
