public class Character {
    private final int maxHealt;
    private int currentHealt;
    private final String name;

    public Character() {
        this("",0);
        this.currentHealt = this.maxHealt;
    }
    public Character(String name,int maxHealt) {
        this.maxHealt = maxHealt;
        this.name = name;
        this.currentHealt = maxHealt;
    }

    public int getMaxHealt() {
        return this.maxHealt;
    }

    public int getCurrentHealt() {
        return this.currentHealt;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.currentHealt == 0)
            return String.format("%s : KO", this.name);
        return String.format("%s : %d / %d", this.name, this.currentHealt ,this.maxHealt);
    }

    public void takeDamage(int amount) {
        if (this.currentHealt - amount < 0)
            this.currentHealt = 0;
        else
            this.currentHealt -= currentHealt;
    }

    public void attack(Character ch) {
        ch.takeDamage(9);
    }
}
