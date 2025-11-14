public class Sorcerer extends Character implements Healer{

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int x, Weapon Wpon){
        super(name, maxHealth, Wpon);
        this.healCapacity = x;
    }

    @Override
    public void heal(Character c){
        if((c.getCurrentHealth() + this.healCapacity)>= c.getMaxHealth()){
            c.setCurrentHealth(c.getMaxHealth());
            return;
        }
        c.setCurrentHealth(c.getCurrentHealth() + this.healCapacity);
    }

    @Override
    public void takeDamage(int damage){

       
        super.setCurrentHealth( super.getCurrentHealth() - damage);
        
        if(super.getCurrentHealth() < 0){
            super.setCurrentHealth(0);
        }
    }
    
    @Override
    public void attack(Character x){
        
        // System.out.println(this.getWponDamage() + " - " + this.getWponName() + " currHealt " + this.getCurrentHealth() );
        if (this.getWponName() == null){
            x.takeDamage(10);
        }else{
            this.heal(this);
            x.takeDamage(this.getWponDamage());
        }
    }
   

    @Override
    public int getHealCapacity(){
        return this.healCapacity;
    }

    @Override
    public String toString(){
        if(super.getCurrentHealth() == 0){
            return String.format("%s is a dead sorcerer. So bad, it could heal %s HP.", super.getName(), this.healCapacity);
        }
        
        return String.format("%s is a sorcerer with %s HP. It can heal %s HP. He has the weapon %s", super.getName(), super.getCurrentHealth(), this.healCapacity, super.getWponName() );

    }
}