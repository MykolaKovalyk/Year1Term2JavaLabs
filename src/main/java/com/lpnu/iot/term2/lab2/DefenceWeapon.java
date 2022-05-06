package com.lpnu.iot.term2.lab2;

public class DefenceWeapon extends Weapon {

    public  static  final float DEFAULT_DAMAGE_REDUCTION = 25;
    public  static  final float DEFAULT_HEALTH = 1;
    public  static  final String DEFAULT_RATED = "7.62 NATO";



    public float blockedDamagePercent;
    public float shieldHealth;
    public String ratedFor;


    public DefenceWeapon() {
        this(-1,
                Weapon.DEFAULT_QUALITY,
                DEFAULT_DAMAGE_REDUCTION,
                DEFAULT_HEALTH,
                DEFAULT_RATED);
    }

    public DefenceWeapon(int id,
                         int quality,
                         float blockedDamagePercent,
                         float shieldHealth,
                         String ratedFor) {
        super(id, quality);

        this.blockedDamagePercent = blockedDamagePercent;
        this.shieldHealth = shieldHealth;
        this.ratedFor = ratedFor;
    }


    public static String getHeaders() {
        return Weapon.getHeaders()
                + ", blockedDamagePercent, shieldHealth, ratedFor";
    }

    @Override
    public String toCSV() {
        return  super.toCSV()
                + ", "
                + blockedDamagePercent
                + ", "
                + shieldHealth
                + ", "
                + ratedFor;
    }
}
