
public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character ch) throws DeadCharacterException {
        if (getCurrentHealth() == 0)
            throw new DeadCharacterException(this);
        if (ch.getCurrentHealth() + this.healCapacity >= ch.getMaxHealth()) {
            ch.setCurrentHealth(ch.getMaxHealth());
        } else {
            ch.setCurrentHealth((ch.getCurrentHealth() + this.healCapacity));
        }
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        return (super.getCurrentHealth() == 0
                ? String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                        super.getName(), getShield(), getHealCapacity())
                : String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                        super.getName(), super.getCurrentHealth(), getHealCapacity(), getShield()))
                + " He has the weapon " + getWeapon().getName();
    }

    @Override
    public void takeDamage(int dmg) throws DeadCharacterException {
        if (getCurrentHealth() == 0)
            throw new DeadCharacterException(this);
        dmg = dmg - shield;
        if (getCurrentHealth() - dmg < 0) {
            this.setCurrentHealth(0);
        } else {
            this.setCurrentHealth(getCurrentHealth() - dmg);
        }
    }

    @Override
    public void attack(Character ch) throws DeadCharacterException {
        if (getCurrentHealth() == 0)
            throw new DeadCharacterException(this);
        this.heal(this);
        ch.takeDamage(this.getWeapon() == null ? 6 : this.getWeapon().getDamage());

    }

}