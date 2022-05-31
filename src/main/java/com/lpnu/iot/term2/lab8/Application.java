package com.lpnu.iot.term2.lab8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*var solider1 =  new Solider();
        var solider2 =  new Solider();

        var gun =  new AssaultWeapon(
                0,
                50,
                100,
                10,
                AssaultWeaponType.Combat);
        var vest = new DefenceWeapon(
                1,
                70,
                10,
                1000,
                "14.5mm NATO");

        var rifle = new AssaultWeapon(
                2,
                100,
                300,
                1000,
                AssaultWeaponType.DistantWarfare);

        solider1.addNewWeapon(vest);
        solider1.addNewWeapon(gun);

        solider2.addNewWeapon(rifle);


        var division =  new Division();

        division.addSolider(solider1);
        division.addSolider(solider2);

        var weaponManager =  new WeaponryManager();

        weaponManager.addWeapon(rifle);
        weaponManager.addWeapon(gun);
        weaponManager.addWeapon(vest);

        WeaponWriter.writeToCSV(weaponManager.getWeaponList());

        for (var weapon : weaponManager.getWeaponList()) {
            System.out.println(weapon.quality);
        }

        weaponManager.sortByQuality(true);

        for (var weapon : weaponManager.getWeaponList()) {
            System.out.println(weapon.quality);
        }

        weaponManager.sortByQuality(false);

        for (var weapon : weaponManager.getWeaponList()) {
            System.out.println(weapon.quality);
        }


        var replacer = new StringNegativeNumberReplacer();

        System.out.println(
                        "hello -321 and 678 "
                        + "-> "
                        + replacer.getModifiedString("hello -321 and 678"));
        */

        SpringApplication.run(Application.class, args);
    }
}
