import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();
    private Weapon weapon;

    // constructor
    public Character(String name, int maxHealth, Weapon weapon) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
        Character.allCharacters.add(this);
        this.weapon = weapon;
    }

    // getters
    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    // setters
    protected void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    // toString
    @Override
    public String toString() {
        return currentHealth == 0 ? String.format("%s : KO", this.name)
                : String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
    }

    // METHODS
    public abstract void takeDamage(int dmg) throws DeadCharacterException;

    public abstract void attack(Character ch) throws DeadCharacterException;

    public static String printStatus() {

        if (allCharacters != null && allCharacters.size() != 0) {
            String res = "------------------------------------------\n" +
                    "Characters currently fighting :\n";
            for (Character ch : allCharacters) {
                res += " - " + ch.toString() + "\n";
            }
            res += "------------------------------------------\n";
            return res;
        } else {
            return "------------------------------------------\nNobody's fighting right now !\n------------------------------------------\n";

        }
    }

    public static Character fight(Character ch1, Character ch2) {
        try {
            while (true) {
                ch1.attack(ch2);
                if (ch2.currentHealth == 0)
                    break;
                ch2.attack(ch1);
                if (ch1.currentHealth == 0)
                    break;
            }
        } catch (DeadCharacterException e) {
            return ch1;
        }

        return ch1.currentHealth == 0 ? ch2 : ch1;
    }
}