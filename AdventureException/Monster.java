public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public String toString() {
        return (super.getCurrentHealth() == 0 ? String.format("%s is a monster and is dead", super.getName())
                : String.format("%s is a monster with %d HP", super.getName(), super.getCurrentHealth()))
                + " He has the weapon " + getWeapon().getName();
    }

    @Override
    public void takeDamage(int dmg) throws DeadCharacterException {
        if (getCurrentHealth() == 0)
            throw new DeadCharacterException(this);
        dmg = dmg * 80 / 100;
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
        ch.takeDamage(this.getWeapon() == null ? 7 : this.getWeapon().getDamage());
    }
}