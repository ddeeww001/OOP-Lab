package om.rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int maxHealthPoint;
    private int healingPoint;
    private String characterClass;
    private Weapon weapon;
    private int damage;
    private int defense;


    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }




    public Character(String name, int level, int maxHealthPoint, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHealthPoint = maxHealthPoint;
        this.healingPoint = maxHealthPoint; // เริ่มต้นเลือดเต็ม
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;

    }

    public void levelUp(){
        level++;
        int increase = 10;
        maxHealthPoint += increase;
        healingPoint =maxHealthPoint;
        System.out.println("\n" + name + " leveled up to Level " + level + "!");
        System.out.println("☑  Max health increased to " + maxHealthPoint + " (full heal applied)");


    }

    public void takeDamage(int damage){
        healingPoint -= damage;
        if(healingPoint <0){
            healingPoint =0;}
        System.out.println("\n"+name+" takes "+damage+" damage! Remaining HP"+ healingPoint +"/"+maxHealthPoint);
    }

    public void attack(Character characterClass){
        System.out.println("\nAttack Damage: " + damage +
                " (Weapon Base: " + weapon.getDamage() +
                " + Level Bonus: " + (level*2) + ")");
    }

    public void heal(int heal){
        this.healingPoint += heal;
        if(this.healingPoint >this.maxHealthPoint){
            this.healingPoint =this.maxHealthPoint;
        }

    }



    public void displayCharacterDetails(){
        //toUpperCase = การบังคับให้ตัวอัหษรเป็นพิมใหญ่ทั้งหมด
        System.out.println("======================");
       // System.out.println(name.toUpperCase());
        System.out.println("Class: "+ characterClass);
        System.out.println("Level: "+ level);
        System.out.println("Health Points: "+ healingPoint +"/"+maxHealthPoint);
        System.out.println("Damage: " + damage );//"\nDefense: " + defense);
        System.out.println("Defense: "+defense);
        System.out.println("Weapon: " + weapon.toString());
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
        return healingPoint;
    }

    public void setHealthPoint(int healingPoint) {
        this.healingPoint = healingPoint;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
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

