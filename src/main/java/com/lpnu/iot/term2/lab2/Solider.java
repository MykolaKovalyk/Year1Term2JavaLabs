package com.lpnu.iot.term2.lab2;

import java.util.ArrayList;

public class Solider {
    public Division division;
    public float effectiveness;
    public ArrayList<Weapon> weapons;



    public Solider() {
        this(0.5f);
    }

    public Solider(float effectiveness) {
        this.effectiveness = effectiveness;
        weapons = new ArrayList<>();
    }



    public void EnterDivision(Division newDivision) {
        division = newDivision;
    }

    public Division LeaveDivision() {
        var oldDivision =  division;
        division = null;

        return oldDivision;
    }



    public void AddNewWeapon(Weapon newWeapon) {
        weapons.add(newWeapon);
    }

    public Weapon GiveBackWeapon(int index) {
        return weapons.remove(index);
    }

    public void GiveBackWeapon(Weapon weaponToGiveBack) {
        weapons.remove(weaponToGiveBack);
    }
}
