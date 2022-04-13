package com.lpnu.iot.term2.main;

import com.lpnu.iot.term2.lab2.*;

public class Main {

    public static void main(String[] args)
    {
        var solider1 =  new Solider();
        var solider2 =  new Solider();

        var division =  new Division();

        var weaponManager =  new WeaponryManager();

        var gun =  new AssaultWeapon();
        var vest =  new DefenceWeapon();

        System.out.println("Hello Java!");
    }
}
