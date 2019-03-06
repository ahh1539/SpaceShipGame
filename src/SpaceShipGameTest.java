import org.junit.Test;
//import temp.ArmoredSpaceShip;
//import temp.Gunship;
//import temp.ShieldedSpaceShip;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpaceShipGameTest {

    //
    // DO NOT MODIFY ANY OF THE TESTS IN THIS SECTION
    //

    /**
     * DO NOT MODIFY: Tests creating a basic space ship.
     */
    @Test
    public void createSpaceShip() {
        String name = "Enterprise";
        SpaceShip ship = new SpaceShip(name);

        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 50, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());
    }

    /**
     * DO NOT MODIFY: Tests the deduct damage method on a basic space ship.
     */
    @Test
    public void deductHitPointsSpaceShip() {
        SpaceShip ship = new SpaceShip("The Black Pearl");

        int amount = 100;
        ship.deductHitPoints(amount);
        int expected = ship.getTotalHitPoints() - amount;
        int actual = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", expected, actual);
    }

    /**
     * DO NOT MODIFY: Tests the isDestroyed() method on a basic space ship.
     */
    @Test
    public void isDestroyedSpaceShip() {
        SpaceShip ship = new SpaceShip("The Death Star");

        boolean before = ship.isDestroyed();
        ship.deductHitPoints(ship.getTotalHitPoints());
        boolean after = ship.isDestroyed();

        assertFalse("Ship should not be destroyed!", before);
        assertTrue("Ship should be destroyed!", after);
    }

    /**
     * DO NOT MODIFY: Tests the underAttack method on the basic space ship.
     */
    @Test
    public void underAttackSpaceShip() {
        SpaceShip attacker = new SpaceShip("TIE Fighter");
        SpaceShip attacked = new SpaceShip("X-Wing Fighter");

        int start = attacked.getCurrentHitPoints();

        attacked.underAttack(attacker);
        attacked.underAttack(attacker);

        int expected = start - attacker.getDamage() * 2;
        int actual = attacked.getCurrentHitPoints();

        assertEquals("Damage after attack is not correct!", expected, actual);
    }

    //
    // MODIFY THE TESTS IN THIS SECTION WHERE INDICATED
    //

    /**
     * Tests crating a GunShip. Works the same as a basic space ship but does
     * 50% more damage.
     */
    @Test
    public void createGunship() {
        String name = "Millennium Falcon";
        // MODIFY THE FOLLOWING LINE AS NEEDED TO CREATE A GUNSHIP

//        SpaceShip ship = new Gunship(name);

        GunDecorator ship = new GunDecorator(new SpaceShip(name));

        // DO NOT MODIFY BELOW THIS LINE
        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 75, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());
    }

    /**
     * Tests crating a temp.ShieldedSpaceShip. Works the same as a basic space ship
     * but has a shield that absorbs damage until depleted.
     */
    @Test
    public void createShieldedShip() {
        String name = "Red 5";
        // MODIFY THE FOLLOWING LINE AS NEEDED TO CREATE A GUNSHIP
//        SpaceShip ship = new ShieldedSpaceShip(name);
        //Ship ship = new ShieldDecorator(new SpaceShip(name));

        ShieldDecorator ship = new ShieldDecorator(new SpaceShip(name));

        // DO NOT MODIFY BELOW THIS LINE
        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 50, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());
    }

    /**
     * Tests the deductHitPoints method on a shielded space ship.
     */
    @Test
    public void deductHitPointsShieldedShip() {
        // MODIFY THE FOLLOWING LINE AS NEEDED TO CREATE SHIELDED SHIP

        //SpaceShip ship = new ShieldedSpaceShip("Serenity");

        ShieldDecorator ship = new ShieldDecorator(new SpaceShip("Serenity"));

        // DO NOT MODIFY BELOW THIS LINE
        int amount = 400;
        int start = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // 100 points left in shield
        int middle = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // shield depleted; -300 to HP
        int end = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", start, middle);
        assertEquals("Damage amount is wrong!", 700, end);
    }

    /**
     * Tests creating an armored space ship. Works the same as a basic space
     * ship, but has armor that deducts damage received by 50%.
     */
    @Test
    public void createArmoredSpaceShip() {
        String name = "Excelsior";
        // MODIFY THE FOLLOWING LINE AS NEEDED TO CREATE AN ARMORED SHIP
        //SpaceShip ship = new ArmoredSpaceShip(name);


        ArmoredDecorator ship = new ArmoredDecorator(new SpaceShip(name));

        // DO NOT MODIFY BELOW THIS LINE
        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 50, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());
    }

    @Test
    public void deductHitPointsArmoredSpaceShip() {
        // MODIFY THE FOLLOWING LINE AS NEEDED TO CREATE ARMORED SHIP
        //SpaceShip ship = new ArmoredSpaceShip("The Flying Dutchman");


        ArmoredDecorator ship = new ArmoredDecorator(new SpaceShip("The Flying Dutchman"));


        // DO NOT MODIFY BELOW THIS LINE
        int amount = 400;
        int start = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // 200 points from HP
        int expected = start - amount / 2;
        int actual = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", expected, actual);
    }

    //
    // AFTER THIS POINT, FINISH IMPLEMENTING THE TESTS FOR EACH COMBINATION OF
    // UPGRADES.
    //

    /**
     * Create a ship with both gunship and armored upgrades.
     */
    @Test
    public void createArmoredGunship() {


        String name = "Armored temp.Gunship";
        // ADD CODE TO CREATE THE ARMORED GUNSHIP
        SpaceShip s = new SpaceShip(name);
        ArmoredDecorator armor = new ArmoredDecorator(s);
        GunDecorator ship = new GunDecorator(armor);


        // UNCOMMENT BUT DO NOT MODIFY!

        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 75, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());

    }

    /**
     * Verify that the armored gunship takes half damage.
     */
    @Test
    public void deductHitPointsArmoredGunship() {


        // ADD CODE TO CREATE THE ARMORED GUNSHIP
        SpaceShip s = new SpaceShip("E");
        ArmoredDecorator armor = new ArmoredDecorator(s);
        GunDecorator ship = new GunDecorator(armor);




        // UNCOMMENT BUT DO NOT MODIFY!

        int amount = 400;
        int start = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // 200 points from HP
        int expected = start - amount / 2;
        int actual = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", expected, actual);

    }

    /**
     * Create a ship with both shield and gunship upgrades.
     */
    @Test
    public void createShieldedGunship() {


        String name = "Shielded temp.Gunship";
        // ADD CODE TO CREATE THE ARMORED GUNSHIP
        SpaceShip s = new SpaceShip(name);
        ShieldDecorator shield = new ShieldDecorator(s);
        GunDecorator ship = new GunDecorator(shield);


        // UNCOMMENT BUT DO NOT MODIFY!
        /*
        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 75, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());
        */
    }

    /**
     * Verify that a shielded gunship absorbs damage as expected.
     */
    @Test
    public void deductHitPointsShieldedGunship() {


        // ADD CODE TO CREATE SHIELDED GUNSHIP
        SpaceShip s = new SpaceShip("e");
        ShieldDecorator shield = new ShieldDecorator(s);
        GunDecorator ship = new GunDecorator(shield);

        // UNCOMMENT BUT DO NOT MODIFY!

        int amount = 400;
        int start = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // 100 points left in shield
        int middle = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // shield depleted; -300 to HP
        int end = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", start, middle);
        assertEquals("Damage amount is wrong!", 700, end);

    }

    @Test
    public void createShieldedArmoredSpaceShip() {


        String name = "Shielded and Armored Ship";
        // ADD CODE TO CREATE THE SHIELDED AND ARMORED SHIP
        SpaceShip s = new SpaceShip(name);
        ArmoredDecorator armor = new ArmoredDecorator(s);
        ShieldDecorator ship = new ShieldDecorator(armor);



        // UNCOMMENT BUT DO NOT MODIFY!
        /*
        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 50, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());
        */
    }

    /**
     * Verify that a shielded and armored space ship absorbs damage correctly.
     */
    @Test
    public void deductHitPointsShieldedArmoredSpaceShip() {


        // ADD CODE TO CREATE SHIELDED AND ARMORED SPACE SHIP; THE SHIELD
        // SHOULD ABSORB DAMAGE BEFORE HITTING THE ARMOR
        SpaceShip s = new SpaceShip("e");
        ArmoredDecorator armor = new ArmoredDecorator(s);
        ShieldDecorator ship = new ShieldDecorator(armor);





        // UNCOMMENT BUT DO NOT MODIFY!

        int amount = 400;
        int start = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // 100 points left in shield
        int middle = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // shield depleted; -150 to HP
        int end = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", start, middle);
        assertEquals("Damage amount is wrong!", 850, end);

    }

    /**
     * Test creating the triple upgrade: armor, shields, and guns.
     */
    @Test
    public void createTrifecta() {


        String name = "The Trifecta";
        SpaceShip s = new SpaceShip(name);
        ArmoredDecorator armor = new ArmoredDecorator(s);
        ShieldDecorator shield = new ShieldDecorator(armor);
        GunDecorator ship = new GunDecorator(shield);


        // ADD CODE TO CREATE A SHIP WITH ALL THREE UPGRADES. NOTE THAT
        // SHIELDS SHOULD ABSORB DAMAGE BEFORE ARMOR.

        // UNCOMMENT BUT DO NOT MODIFY!

        assertEquals("Names do not match!", name, ship.getName());
        assertEquals("Total hit points do not match!", 1000,
                ship.getTotalHitPoints());
        assertEquals("Current hit points do not match!", 1000,
                ship.getCurrentHitPoints());
        assertEquals("Damage does not match!", 75, ship.getDamage());
        assertFalse("Ship should not be destroyed!", ship.isDestroyed());

    }

    /**
     * Verify that a trifecta space ship absorbs damage correctly.
     */
    @Test
    public void deductHitPointsTrifecta() {


        // ADD CODE TO CREATE A SHIP WITH ALL THREE UPGRADES. NOTE THAT
        // SHIELDS SHOULD ABSORB DAMAGE BEFORE ARMOR.
        SpaceShip s = new SpaceShip("yeetmaster");
        ArmoredDecorator armor = new ArmoredDecorator(s);
        ShieldDecorator shield = new ShieldDecorator(armor);
        GunDecorator ship = new GunDecorator(shield);

        // UNCOMMENT BUT DO NOT MODIFY!
        /*
        int amount = 400;
        int start = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // 100 points left in shield
        int middle = ship.getCurrentHitPoints();
        ship.deductHitPoints(amount); // shield depleted; -150 to HP
        int end = ship.getCurrentHitPoints();

        assertEquals("Damage amount is wrong!", start, middle);
        assertEquals("Damage amount is wrong!", 850, end);
        */
    }


}
