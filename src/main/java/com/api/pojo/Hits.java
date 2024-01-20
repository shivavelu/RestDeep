package com.api.pojo;

public class Hits {

    private int tamil;
    private int telugu;
    private String year;

    public Hits(int tamil, int telugu, String year) {
        this.tamil = tamil;
        this.telugu = telugu;
        this.year = year;
    }

    public int getTamil() {
        return tamil;
    }

    public void setTamil(int tamil) {
        this.tamil = tamil;
    }

    public int getTelugu() {
        return telugu;
    }

    public void setTelugu(int telugu) {
        this.telugu = telugu;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
