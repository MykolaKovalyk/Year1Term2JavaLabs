package ua.lviv.iot;

import com.lpnu.iot.term2.lab2.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.*;


/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{

    public Solider solider1;
    public Solider solider2;

    public Division division;

    public Weapon gun;
    public Weapon rifle;
    public Weapon vest;
    public WeaponryManager manager;

    @BeforeEach
    public void setUp() {

        solider1 =  new Solider();
        solider2 =  new Solider();

        division = new Division();

        gun =  new AssaultWeapon(0, 50, 100, 10, AssaultWeaponType.Combat);
        vest =  new DefenceWeapon(1, 70 , 10, 1000, "14.5mm NATO");

        rifle =  new AssaultWeapon(2, 100, 300, 1000, AssaultWeaponType.DistantWarfare);

        manager =  new WeaponryManager();

        manager.addWeapon(gun);
        manager.addWeapon(vest);
        manager.addWeapon(rifle);

    }


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */


    public void testFindAllAssaultWeaponsOfType() {
        var weaponsList = manager.findAllAssaultWeaponsOfType(AssaultWeaponType.Combat);
        assertTrue(weaponsList.contains(gun));
    }

    public void testFindAllDefenceWeapons() {
        assertTrue(manager.findAllDefenceWeapons().contains(vest));
    }

    public void testSoliderEnteringAndLeavingDivision() {
        division.addSolider(solider1);
        division.addSolider(solider2);

        assertTrue(division.soliders.contains(solider1));
        assertNotNull(solider1.division);

        division.removeSolider(solider2);

        assertFalse(division.soliders.contains(solider2));
        assertNull(solider2.division);
    }

    public void testSoliderAcquiringAndGivingBackWeapon() {

        solider2.addNewWeapon(vest);
        solider2.addNewWeapon(gun);

        assertTrue(solider2.weapons.contains(gun));
        assertTrue(solider2.weapons.contains(vest));


        solider2.giveBackWeapon(1);

        assertFalse(solider2.weapons.contains(gun));
        assertTrue(solider2.weapons.contains(vest));


        solider2.giveBackWeapon(gun);

        assertFalse(solider2.weapons.contains(gun));
    }

    public void testWeaponManagerAcquiringAndGivingOutWeapons() {
        assertTrue(manager.getWeaponList().contains(gun));
        assertTrue(manager.getWeaponList().contains(vest));
        assertTrue(manager.getWeaponList().contains(rifle));


        manager.takeWeapon(rifle);

        assertTrue(manager.getWeaponList().contains(gun));
        assertTrue(manager.getWeaponList().contains(vest));
        assertFalse(manager.getWeaponList().contains(rifle));

        manager.takeWeapon(vest);

        assertTrue(manager.getWeaponList().contains(gun));
        assertFalse(manager.getWeaponList().contains(vest));
    }

    public void testAllSortAndFindMethodsInWeaponManager() {
        manager.sortById(true);
        var listToCheck =  manager.getWeaponList();
        for(int i = 1; i < listToCheck.size(); i++)
            assertTrue( listToCheck.get(i - 1).id >= listToCheck.get(i).id);

        manager.sortByQuality(false);
        listToCheck =  manager.getWeaponList();
        for(int i = 1; i < listToCheck.size(); i++)
            assertTrue( listToCheck.get(i - 1).quality <= listToCheck.get(i).quality);
    }
}
