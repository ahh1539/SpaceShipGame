public class ArmoredDecorator extends SpaceshipDecorator {
    public ArmoredDecorator(Ship ship) {
        super(ship);
    }
    @Override
    public void deductHitPoints(int amount) {
        int actualAmount = amount / 2;
        super.deductHitPoints(actualAmount);
    }
}
