public class SpaceshipDecorator implements Ship {

    Ship ship;

    public SpaceshipDecorator(Ship ship){
        this.ship = ship;
    }

    @Override
    public String getName() {
        return ship.getName();
    }

    @Override
    public int getTotalHitPoints() {
        return ship.getTotalHitPoints();
    }

    @Override
    public int getCurrentHitPoints() {
        return ship.getCurrentHitPoints();
    }

    @Override
    public int getDamage() {
        return ship.getDamage();
    }

    @Override
    public void underAttack(SpaceShip attacker) {
        int damage = attacker.getDamage();
        deductHitPoints(damage);
    }

    @Override
    public boolean isDestroyed() {
        return ship.getCurrentHitPoints() <= 0;
    }

    @Override
    public void deductHitPoints(int amount) {
        ship.deductHitPoints(amount);
    }
}
