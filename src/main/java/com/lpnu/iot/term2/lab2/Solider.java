package com.lpnu.iot.term2.lab2;

import java.util.ArrayList;

public class Solider {

    public  static  final float DEFAULT_EFFECTIVENESS = 0.5f;



    public Division division;
    public float effectiveness;
    public ArrayList<Weapon> weapons;



    public Solider() {
        this(DEFAULT_EFFECTIVENESS);
    }

    public Solider(float effectiveness) {
        this.effectiveness = effectiveness;
        weapons = new ArrayList<>();
    }



    public void addNewWeapon(Weapon newWeapon) {
        weapons.add(newWeapon);
    }

    public Weapon giveBackWeapon(int index) {
        return weapons.remove(index);
    }

    public void giveBackWeapon(Weapon weaponToGiveBack) {
        weapons.remove(weaponToGiveBack);
    }
}
