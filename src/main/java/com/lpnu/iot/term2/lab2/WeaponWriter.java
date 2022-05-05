package com.lpnu.iot.term2.lab2;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class WeaponWriter {

    private WeaponWriter() {

    }

    public static void writeToCSV(List<Weapon> weapons) {
        var defences =  new ArrayList<DefenceWeapon>();
        var assaults =  new ArrayList<AssaultWeapon>();

        for (var weapon : weapons) {
            try {
                var casted =  (DefenceWeapon) weapon;
                defences.add(casted);
            } catch (java.lang.ClassCastException e) {
                assaults.add(((AssaultWeapon) weapon));
            }
        }

        try {
            var writer = new FileWriter("weapons.csv");


            writer.write(DefenceWeapon.getHeaders() + "\r\n");
            for (var weapon : defences)
                writer.write(weapon.toCSV() + "\r\n");

            writer.write(AssaultWeapon.getHeaders() + "\r\n");
            for (var weapon : assaults)
                writer.write(weapon.toCSV() + "\r\n");

            writer.close();
        } catch (java.io.IOException e) {
            System.out.println(
                    "Unable to write weapons to file: "
                            + "an error occurred.");
            e.printStackTrace();
        }

    }


}
