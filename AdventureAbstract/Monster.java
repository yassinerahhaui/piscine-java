public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString(){
        if(super.getCurrentHealth() == 0){
            return String.format("%s is a monster and is dead", super.getName() );
        }
        
        return String.format("%s is a monster with %d HP", super.getName(), super.getCurrentHealth());
    }

    @Override
    public void takeDamage(int damage){
        int x = super.getCurrentHealth() - (int) (damage * 0.8);
        // int s = (int) Math.floor((double) super.getCurrentHealth() - x);
        // System.out.println("Character "+super.printStatus() +" currentHealth:"+super.getCurrentHealth()+ " damage "+damage+ " 80% " +x+" res "+s);
        
        if(x < 0){
            x = 0;
        }
        super.setCurrentHealth(x);
    }

    @Override
    public void attack(Character x){
        x.takeDamage(7);
    }
    
}