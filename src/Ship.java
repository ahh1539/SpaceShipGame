public interface Ship {

    public abstract String getName();

    public abstract int getTotalHitPoints();

    public abstract int getCurrentHitPoints();

    /**
     * Returns the amount of damage that this ship does when it attacks.
     *
     * @return The amount of damage this ship does when it attacks.
     */
    public abstract int getDamage();

    /**
     * Called when another {@link SpaceShip} attacks this ship.
     *
     * @param attacker The attacking {@link SpaceShip}.  Used to determine the
     *                 amount of damage sustained.
     */
    public abstract void underAttack(SpaceShip attacker);

    /**
     * Returns true if the ship has been destroyed.
     *
     * @return True if the ship has been reduced to 0 hit points.
     */
    public abstract boolean isDestroyed();

    /**
     * Deducts the specified number of hit points from the ship's current hit
     * points.
     *
     * @param amount The amount of hit points to deduct.
     */
    public abstract void deductHitPoints(int amount);
}
