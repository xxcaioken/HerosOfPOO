public class Archer extends Person implements Ibattle{
    public int weapon;
    private int damage;
    private int defense;    
        
    
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDamage(int force){
        this.damage = force + weapon;
    }

    public int getDamage() {
        return damage;
    }
    
    @Override
    public int atack(int defense) {
        return getDamage()  - defense;
    }
    @Override
    public int defense(int damage) {
        return getDefense();
        
    }
}
