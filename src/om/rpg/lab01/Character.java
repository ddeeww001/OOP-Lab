package om.rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int maxHealthPoint;
    private int healthPoint;
    private String charaterClass;
    private Weapon weapon;
    private int damage;
    private int defense;

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

  


    public Character(
            String name,
            int level,
            int maxHealthPoint,
            Weapon weapon,
            int defense,
            String characterClass){
        this.name = name;
        this.level = level;
        this.maxHealthPoint=maxHealthPoint;
        this.healthPoint=maxHealthPoint;
        this.weapon=weapon;
        this.charaterClass=characterClass;
        this.damage=(level*2)+weapon.getDamage();
        this.defense=defense;
    }

    public void levelUp(){
        level++;
        int increase = 10;
        maxHealthPoint += increase;
        healthPoint=maxHealthPoint;
        System.out.println("\n" + name + " leveled up to Level " + level + "!");
        System.out.println("   Max health increased to " + maxHealthPoint + " (full heal applied)");


    }

    public void takeDamage(int damage){
        healthPoint -= damage;
        if(healthPoint<0){healthPoint=0;}
        System.out.println("\n"+name+" takes "+damage+" damage! Remaining HP"+healthPoint+"/"+maxHealthPoint);
    }

    public void attack(){
        System.out.println("\nAttack Damage: " + damage +
                " (Weapon Base: " + weapon.getDamage() +
                " + Level Bonus: " + (level*2) + ")");
    }

    public void heal(int heal){
        this.healthPoint += heal;
        if(this.healthPoint>this.maxHealthPoint){
            this.healthPoint=this.maxHealthPoint;
        }

    }



    public void displayCharacterDetails(){
        //toUpperCase = การบังคับให้ตัวอัหษรเป็นพิมใหญ่ทั้งหมด
        System.out.println("--- "+name.toUpperCase()+" ---");
        System.out.println("Class: "+charaterClass);
        System.out.println("Level: "+ level);
        System.out.println("Health Points: "+healthPoint+"/"+maxHealthPoint);
        System.out.println("Weapon: "+weapon);
        System.out.println("Damage"+damage);
        System.out.println("Defense"+defense);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharaterClass() {
        return charaterClass;
    }

    public void setCharaterClass(String charaterClass) {
        this.charaterClass = charaterClass;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }




}
