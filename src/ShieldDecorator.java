public class ShieldDecorator extends SpaceshipDecorator {

    private int shieldHitPoints;
    public ShieldDecorator(Ship ship) {
        super(ship);
        shieldHitPoints = 500;
    }


    /**
     * This craft has a shield that absorbs all incoming damage until the
     * shield is depleted.
     *
     * @param amount The amount of hit points to deduct.
     */

    @Override
    public void deductHitPoints(int amount) {
        if(shieldHitPoints > amount) {
            // the shield absorbs all damage
            shieldHitPoints = shieldHitPoints - amount;
        }
        else if(shieldHitPoints > 0) {
            // the shield absorbs some damage and is depleted.  the remaining
            // damage is dealt to the ship itself.
            super.deductHitPoints(amount - shieldHitPoints);
            shieldHitPoints = 0;
        }
        else {
            // the shield is gone; full damage is dealt
            super.deductHitPoints(amount);
        }
    }
}
