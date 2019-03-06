public class GunDecorator extends SpaceshipDecorator {
    public GunDecorator(Ship ship) {
        super(ship);
    }

    @Override
    public int getDamage() {
        return (int)(super.getDamage() * 1.5);
    }
}
