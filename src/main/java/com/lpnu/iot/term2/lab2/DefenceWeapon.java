package com.lpnu.iot.term2.lab2;

public class DefenceWeapon extends Weapon {
    public float blockedDamagePercent;
    public float shieldHealth;
    public String ratedFor;


    public DefenceWeapon()
    {
        this(-1, 100, 25, 100, "7.62 NATO");
    }

    public DefenceWeapon(int id, int quality, float blockedDamagePercent, float shieldHealth, String ratedFor)
    {
        super(id, quality);

        this.blockedDamagePercent = blockedDamagePercent;
        this.shieldHealth = shieldHealth;
        this.ratedFor = ratedFor;
    }


    public static String getHeaders()
    {
        return Weapon.getHeaders() + ", blockedDamagePercent, shieldHealth, ratedFor";
    }

    public String toCSV()
    {
        return  super.toCSV() + ", " + blockedDamagePercent + ", " + shieldHealth + ", " + ratedFor;
    }
}
