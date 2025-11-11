public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character() {
        // this("",0);
        this.maxHealth = 0;
        this.name = ""; 
    }
    public Character(String name,int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getcurrentHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.currentHealth == 0)
            return String.format("%s : KO", this.name);
        return String.format("%s : %d / %d", this.name, this.currentHealth ,this.maxHealth);
    }

    public void takeDamage(int damage) {
        this.currentHealthh -= damage;
        if (this.currentHealthh < 0)
            this.currentHealthh = 0;
    }

    public void attack(Character ch) {
        ch.takeDamage(9);
    }
}
