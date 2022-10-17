public class Archer extends Person implements Ibattle {
    public int weaponDef;
    public int weaponAtk;
    private int damage;
    private int defense;
    private String name;
    private int lifePoints = 160;
    private String classe = "guerreiro";
    private int position;

    public void archer(int weapon) {
        setWeaponAtk(weapon);
        setWeaponDef(weapon);
        setDamage();
        setDefense();
        setPositionOnBattle(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponAtk(int weaponAtk) {
        if (weaponAtk == 1)
            this.weaponAtk = 12;
        if (weaponAtk == 2)
            this.weaponAtk = 15;
    }

    public void setWeaponDef(int weaponDef) {
        if (weaponDef == 1)
            this.weaponDef = 13;
        if (weaponDef == 2)
            this.weaponDef = 10;
    }

    public void setDefense() {
        this.defense = 30 + this.weaponDef;
    }

    public void setDamage() {
        this.damage = 20 + this.weaponAtk;
    }

    @Override
    public void setPositionOnBattle(int position) {
        this.position = position;
    }

    @Override
    public int getPositionOnBattle() {
        return this.position;
    }

    @Override
    public void setLifePoints(int damage) {
        double defesa = this.defense;
        if(this.position==1)
            defesa = defesa + (defesa*0.1);
        int newLifePoints =  this.defense-damage;
        if(newLifePoints<0)
            this.lifePoints = this.lifePoints + newLifePoints;
    }

    @Override
    public String getClasse() {
        return classe;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int atack(int defense) {
        return getDamage() - defense;
    }

    @Override
    public int defense(int damage) {
        return getDefense();

    }
}
