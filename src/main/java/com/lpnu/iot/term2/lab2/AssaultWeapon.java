package com.lpnu.iot.term2.lab2;

import java.util.List;

public class AssaultWeapon extends Weapon {
    public float damage;
    public float effectiveRange;
    public AssaultWeaponType assaultType;


    public AssaultWeapon()
    {
        this(-1, 100, 100, 1, AssaultWeaponType.Combat);
    }

    public AssaultWeapon(int id, int quality, float damage, float effectiveRange, AssaultWeaponType assaultType)
    {
        super(id, quality);

        this.damage = damage;
        this.effectiveRange = effectiveRange;
        this.assaultType = assaultType;
    }

    public static String getHeaders()
    {
        return Weapon.getHeaders() + ", damage, effectiveRange, assaultType";
    }

    public String toCSV()
    {
        return  super.toCSV() + ", " + damage + ", " + effectiveRange + ", " + assaultType;
    }
}
