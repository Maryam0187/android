package com.example.maryam.lab9task2;

import java.sql.Date;

public class Prayer {
    String id;
    String Fajar;
    String Dhuhar;
    String Asar;
    String Maghrib;
    String Isha;
    String today;

    public Prayer() {
        Fajar = "Not Selected";
        Dhuhar = "Not Selected";
        Asar = "Not Selected";
        Maghrib = "Not Selected";
        Isha = "Not Selected";
        this.today = today;
        id="1234";
    }

    public Prayer(String id, String fajar, String dhuhar, String asar, String maghrib, String isha, String today) {
        this.id = id;
        Fajar = fajar;
        Dhuhar = dhuhar;
        Asar = asar;
        Maghrib = maghrib;
        Isha = isha;
        this.today = today;
    }

    public String getFajar() {
        return Fajar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFajar(String fajar) {
        Fajar = fajar;
    }

    public String getDhuhar() {
        return Dhuhar;
    }

    public void setDhuhar(String dhuhar) {
        Dhuhar = dhuhar;
    }

    public String getAsar() {
        return Asar;
    }

    public void setAsar(String asar) {
        Asar = asar;
    }

    public String getMaghrib() {
        return Maghrib;
    }

    public void setMaghrib(String maghrib) {
        Maghrib = maghrib;
    }

    public String getIsha() {
        return Isha;
    }

    public void setIsha(String isha) {
        Isha = isha;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }
}
