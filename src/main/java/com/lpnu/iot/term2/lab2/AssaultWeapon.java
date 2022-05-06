package com.lpnu.iot.term2.lab2;


public class AssaultWeapon extends Weapon {

    public  static  final float DEFAULT_DAMAGE = 100;
    public  static  final float DEFAULT_RANGE = 1;


    public float damage;
    public float effectiveRange;
    public AssaultWeaponType assaultType;


    public AssaultWeapon() {
        this(-1,
                Weapon.DEFAULT_QUALITY,
                DEFAULT_DAMAGE,
                DEFAULT_RANGE,
                AssaultWeaponType.Combat);
    }

    public AssaultWeapon(int id,
                         int quality,
                         float damage,
                         float effectiveRange,
                         AssaultWeaponType assaultType) {
        super(id, quality);

        this.damage = damage;
        this.effectiveRange = effectiveRange;
        this.assaultType = assaultType;
    }

    public static String getHeaders() {
        return Weapon.getHeaders()
                + ", damage, effectiveRange, assaultType";
    }

    @Override
    public String toCSV() {
        return  super.toCSV()
                + ", "
                + damage
                + ", "
                + effectiveRange
                + ", "
                + assaultType;
    }
}
