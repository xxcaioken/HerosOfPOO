public class Dragon implements Ibattle {
    public int weaponDef;
    public int weaponAtk;
    private int damage = 30;
    private int defense = 30;
    private String name = "Dragão";
    private int lifePoints = 300;
    private String classe = "DRAGÃO";


    


    public void setLifePoints(int damage) {
        int newLifePoints =  this.defense-damage;
        if(newLifePoints<0)
            this.lifePoints = this.lifePoints + newLifePoints;
    }

    public String getClasse() {
        return classe;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int atack(int defense) {
        return getDamage() - defense;
    }

    public int defense(int damage) {
        return getDefense();

    }
}
