public class Sorcerer extends Character implements Healer {
    int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

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
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", getName(), getCurrentHealth(), getHealCapacity());
        return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), getCurrentHealth());
    }

}