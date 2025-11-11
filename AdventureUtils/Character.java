import java.util.ArrayList;
import java.util.List;


public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<Character>();

    public Character(String name,int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
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

    public static String printStatus() {
        String result = "";
        result += "------------------------------------------\n";
        if (!allCharacters.isEmpty()) {
            result += "Characters currently fighting :\n";
            for (Character ch : allCharacters) {
                result += "- " + ch.toString() + "\n";
            }
        } else {
            result += "Nobody's fighting right now !\n";    
        }
        result += "------------------------------------------\n";
        return result;
    }

    public static Character fight(Character first, Character second) {
        boolean firstIsAttak = true;
        while (first.getCurrentHealth() > 0 && second.getCurrentHealth() > 0) {
            if (firstIsAttak) {
                first.attack(second);
                firstIsAttak = false;
            } else {
                second.attack(first);
                firstIsAttak = true;
            }
        }
        if (first.getCurrentHealth() == 0) 
            return second;
        return first;
    }

    public static void main(String[] args) {
        System.out.print(Character.printStatus());

        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 15);

        System.out.print(Character.printStatus());

        Character winner = Character.fight(aragorn, uruk);

        System.out.println(winner.toString());
        System.out.print(Character.printStatus());
    }
}
