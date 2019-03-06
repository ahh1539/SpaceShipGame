//package temp;
//
///**
// * One of three upgraded ships that players can choose when they reach level
// * 10.  This ship has extra tough armor that absorbs 50% of incoming damage.
// *
// * Created by Bobby on 6/30/2017.
// */
//public class ArmoredSpaceShip extends SpaceShip {
//    /**
//     * Creates a level-10 armored ship with the given name.
//     *
//     * @param name The name given to the ship by its player/owner.
//     */
//    public ArmoredSpaceShip(String name) {
//        super(name);
//    }
//
//    /**
//     * The extra tough armor on this ship absorbs 50% of any damage taken.
//     *
//     * @param amount The amount of hit points to deduct.
//     */
//    @Override
//    public void deductHitPoints(int amount) {
//        int actualAmount = amount / 2;
//        super.deductHitPoints(actualAmount);
//    }
//}
