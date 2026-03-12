package com.rpg.lab06;

public abstract class Character implements Destructible {
    protected String name;
    protected int level;
    protected int maxHp;
    protected int hp;
    protected int damage;
    protected int defense;
    protected Weapon weapon;
    protected String type;
    protected Attack attack;
    protected boolean isAlive;


    public Character(String name, int level, int maxHp, int damage, int defense, Weapon weapon, String type) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.type = type;
        this.isAlive = true;
        this.attack = new BaseAttack();

    }

    // Overloaded constructor for heroes (defaults type to role)
    public Character(String name, int level, int maxHp, int damage, int defense, Weapon weapon) {
        this(name, level, maxHp, damage, defense, weapon, "Hero");
    }

    public void heal(int heal){
        this.hp += heal;
        if(this.hp>this.maxHp){
            this.hp=this.maxHp;
        }
    }


    public String getName() { return name; }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Attack getAttack() {
        return this.attack;
    }

    public void attack(Destructible target) {
        attack.attack(this, target);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHealthPoints() {
        return hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void receiveDamage(int amount) {
        int actualDamage = amount - defense;
        if (actualDamage < 0) actualDamage = 0;
        this.hp -= actualDamage;

        System.out.println("Raw Attack Damage: " + amount);
        System.out.println(name + "'s Defense: " + defense + " (reduces damage from " + amount + " to " + actualDamage + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);
        System.out.println(name + "'s HP: " + hp + "/" + maxHp);
    }

    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " (" + type.toUpperCase() + ") ---");
        System.out.println("Status: " + (hp > 0 ? "Active" : "Defeated"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);

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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public void takeDamage(int amount) {

    }

    @Override
    public boolean isDestroyed() {
        return this.hp <= 0 ;
    }

}