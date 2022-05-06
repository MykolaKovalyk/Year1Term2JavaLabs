package ua.lviv.iot;

import com.lpnu.iot.term2.lab2.*;
import com.sun.tools.jconsole.JConsoleContext;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Comparator;


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

        manager.AddWeapon(gun);
        manager.AddWeapon(vest);
        manager.AddWeapon(rifle);

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
        var weaponsList = manager.FindAllAssaultWeaponsOfType(AssaultWeaponType.Combat);
        assertTrue(weaponsList.contains(gun));
    }

    public void testFindAllDefenceWeapons() {
        assertTrue(manager.FindAllDefenceWeapons().contains(vest));
    }

    public void testSoliderEnteringAndLeavingDivision() {
        division.AddSolider(solider1);
        division.AddSolider(solider2);

        assertTrue(division.soliders.contains(solider1));
        assertNotNull(solider1.division);

        division.RemoveSolider(solider2);

        assertFalse(division.soliders.contains(solider2));
        assertNull(solider2.division);
    }

    public void testSoliderAcquiringAndGivingBackWeapon() {

        solider2.AddNewWeapon(vest);
        solider2.AddNewWeapon(gun);

        assertTrue(solider2.weapons.contains(gun));
        assertTrue(solider2.weapons.contains(vest));


        solider2.GiveBackWeapon(1);

        assertFalse(solider2.weapons.contains(gun));
        assertTrue(solider2.weapons.contains(vest));


        solider2.GiveBackWeapon(gun);

        assertFalse(solider2.weapons.contains(gun));
    }

    public void testWeaponManagerAcquiringAndGivingOutWeapons() {
        assertTrue(manager.GetWeaponList().contains(gun));
        assertTrue(manager.GetWeaponList().contains(vest));
        assertTrue(manager.GetWeaponList().contains(rifle));


        manager.TakeWeapon(rifle);

        assertTrue(manager.GetWeaponList().contains(gun));
        assertTrue(manager.GetWeaponList().contains(vest));
        assertFalse(manager.GetWeaponList().contains(rifle));

        manager.TakeWeapon(vest);

        assertTrue(manager.GetWeaponList().contains(gun));
        assertFalse(manager.GetWeaponList().contains(vest));
    }

    public void testAllSortAndFindMethodsInWeaponManager() {
        manager.SortById(true);
        var listToCheck =  manager.GetWeaponList();
        for(int i = 1; i < listToCheck.size(); i++)
            assertTrue( listToCheck.get(i - 1).id >= listToCheck.get(i).id);

        manager.SortByQuality(false);
        listToCheck =  manager.GetWeaponList();
        for(int i = 1; i < listToCheck.size(); i++)
            assertTrue( listToCheck.get(i - 1).quality <= listToCheck.get(i).quality);
    }
}
