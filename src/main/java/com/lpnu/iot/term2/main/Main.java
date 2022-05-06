package com.lpnu.iot.term2.main;

import com.lpnu.iot.term2.lab2.*;

public class Main {

    public static void main(String[] args)
    {
        var solider1 =  new Solider();
        var solider2 =  new Solider();

        var gun =  new AssaultWeapon(0, 50, 100, 10, AssaultWeaponType.Combat);
        var vest =  new DefenceWeapon(1, 70 , 10, 1000, "14.5mm NATO");

        var rifle =  new AssaultWeapon(2, 100, 300, 1000, AssaultWeaponType.DistantWarfare);

        solider1.AddNewWeapon(vest);
        solider1.AddNewWeapon(gun);

        solider2.AddNewWeapon(rifle);

        var division =  new Division();

        division.AddSolider(solider1);
        division.AddSolider(solider2);

        var weaponManager =  new WeaponryManager();

        weaponManager.AddWeapon(rifle);
        weaponManager.AddWeapon(gun);
        weaponManager.AddWeapon(vest);

        for(var weapon : weaponManager.GetWeaponList())
            System.out.println(weapon.quality);

        weaponManager.SortByQuality(true);

        for(var weapon : weaponManager.GetWeaponList())
            System.out.println(weapon.quality);

        weaponManager.SortByQuality(false);

        for(var weapon : weaponManager.GetWeaponList())
            System.out.println(weapon.quality);

        System.out.println("Hello Java!");
    }
}
