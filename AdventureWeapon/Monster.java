public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon Wpon) {
        super(name, maxHealth, Wpon);
    }

    @Override
    public String toString(){
        if(super.getCurrentHealth() == 0){
            return String.format("%s is a monster and is dead", super.getName() );
        }
        
        return String.format("%s is a monster with %d HP. He has the weapon %s", super.getName(), super.getCurrentHealth(), super.getWponName());
    }

    @Override
    public void takeDamage(int damage){
        int x = super.getCurrentHealth() - (int) (damage * 0.8);

        if(x < 0){
            x = 0;
        }
        super.setCurrentHealth(x);
    }

    @Override
    public void attack(Character x){

        if (this.getWponName() == null){
            x.takeDamage(7);
        }else{
            x.takeDamage(this.getWponDamage());
        }
    }

}