package com.lpnu.iot.term2.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponryManager {

    protected ArrayList<Weapon> availableWeapons;

    public WeaponryManager() {
        availableWeapons = new ArrayList<>();
    }


    public void addWeapon(Weapon newWeapon) {
        availableWeapons.add(newWeapon);
    }

    public void takeWeapon(Weapon neededWeapon) {
        availableWeapons.remove(neededWeapon);
    }



    public void sortById(boolean descending) {
        availableWeapons.sort(
                (weaponA, weaponB) ->
                        descending ? weaponB.id - weaponA.id
                                : weaponA.id - weaponB.id);
    }

    public void sortByQuality(boolean descending) {
        availableWeapons.sort(
                (weaponA, weaponB) ->
                        descending ? weaponB.quality - weaponA.quality
                                : weaponA.quality - weaponB.quality);
    }

    public List<Weapon> getWeaponList() {
        return Collections.unmodifiableList(availableWeapons);
    }



    public ArrayList<Weapon> findAllAssaultWeaponsOfType(
            AssaultWeaponType type) {

        var found =  new ArrayList<Weapon>();

        for (var weapon : availableWeapons) {
            try {
                var casted = ((AssaultWeapon) weapon);

                if (casted.assaultType == type) {
                    found.add(weapon);
                }
            } catch (java.lang.ClassCastException e) { }
        }

        return found;
    }

    public ArrayList<Weapon> findAllDefenceWeapons() {

        var found =  new ArrayList<Weapon>();

        for (var weapon : availableWeapons) {
            try {
               var asDefence =  (DefenceWeapon) weapon;
               found.add(asDefence);
            } catch (java.lang.ClassCastException e) { }
        }

        return found;
    }
}
