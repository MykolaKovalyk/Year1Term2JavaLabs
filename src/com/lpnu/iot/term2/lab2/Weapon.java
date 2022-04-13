package com.lpnu.iot.term2.lab2;

public class Weapon {
    public int id;
    public int quality;


    public Weapon() {
        this(0, 100);
    }

    public Weapon(int id, int quality) {
        this.id = id;
        this.quality = quality;
    }
}
