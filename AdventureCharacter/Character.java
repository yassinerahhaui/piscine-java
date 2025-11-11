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

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.currentHealth == 0)
            return String.format("%s : KO", getName());
        return String.format("%s : %d/%d", getName(), getCurrentHealth() , getMaxHealth());
    }

    public void takeDamage(int damage) {
        this.currentHealth -= damage;
        if (this.currentHealth < 0)
            this.currentHealth = 0;
    }

    public void attack(Character ch) {
        ch.takeDamage(9);
    }
}
