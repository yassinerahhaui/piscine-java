public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
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
    public String toString() {
        return (getCurrentHealth() == 0
                ? String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), getHealCapacity())
                : String.format("%s is a sorcerer with %d HP. It can heal %d HP.", getName(), getCurrentHealth(),
                        getHealCapacity()))
                + " He has the weapon " + getWeapon().getName();
    }

    @Override
    public void takeDamage(int dmg) throws DeadCharacterException {
        if (getCurrentHealth() == 0)
            throw new DeadCharacterException(this);
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
        ch.takeDamage(this.getWeapon() == null ? 10 : this.getWeapon().getDamage());
    }

}