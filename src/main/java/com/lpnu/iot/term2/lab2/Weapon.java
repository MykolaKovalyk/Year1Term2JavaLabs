package com.lpnu.iot.term2.lab2;

public class Weapon {

    public static final int DEFAULT_QUALITY = 100;


    public int id;
    public int quality;


    public Weapon() {
        this(0, DEFAULT_QUALITY);
    }

    public Weapon(int id, int quality) {
        this.id = id;
        this.quality = quality;
    }


    public static String getHeaders() {
        return "id, quality";
    }

    public String toCSV() {
        return id + ", " + quality;
    }
}
