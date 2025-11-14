public class Templar extends Character implements Tank, Healer {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon Wpon){
        super(name, maxHealth, Wpon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }
    
    @Override
    public void heal(Character c){
        if((c.getCurrentHealth() + this.healCapacity) >= c.getMaxHealth()){
            c.setCurrentHealth(c.getMaxHealth());
            return;
        }
        c.setCurrentHealth(c.getCurrentHealth() + this.healCapacity);
    }


    @Override
    public void takeDamage(int damage){

       
        super.setCurrentHealth( super.getCurrentHealth() - (damage - this.shield));
        
        if(super.getCurrentHealth() < 0){
            super.setCurrentHealth(0);
        }
    }
    
   @Override
    public void attack(Character x){
        
        if (this.getWponName() == null){
            x.takeDamage(6);
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
    public int getShield(){
        return this.shield;
    }

    @Override
    public String toString(){
        if (super.getCurrentHealth() == 0){
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", super.getName(), this.shield, this.healCapacity);
        }


        return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d. He has the weapon %s", super.getName(), super.getCurrentHealth(), this.getHealCapacity(), this.shield,super.getWponName());
    }
}