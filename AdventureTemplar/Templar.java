public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;
    
    public Templar(String name, int maxHealth,int healCapacity,int shield) {
        super(name,maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public int getShield() {
        return this.shield;
    }

    @Override
    public void heal(Character ch) {
        int max = ch.getCurrentHealth() + this.getHealCapacity();
        if (max > ch.getMaxHealth())
            ch.setCurrentHealth(ch.getMaxHealth());
        else
            ch.setCurrentHealth(max);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() != 0)
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", getName(), getCurrentHealth(), getHealCapacity(), getShield());
        else
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",getName(), getShield(), getHealCapacity());
    }

}