package com.rpg.lab03;

public class Character {
    protected String name;
    protected int level;
    protected int maxHp;
    protected int hp;
    protected int damage;
    protected int defense;
    protected Weapon weapon;
    protected String type;

    public void heal(int heal){
        this.hp += heal;
        if(this.hp>this.maxHp){
            this.hp=this.maxHp;
        }
    }

    public Character(String name, int level, int maxHp, int damage, int defense, Weapon weapon, String type) {
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.type = type;
    }

    // Overloaded constructor for heroes (defaults type to role)
    public Character(String name, int level, int maxHp, int damage, int defense, Weapon weapon) {
        this(name, level, maxHp, damage, defense, weapon, "Hero");
    }


    public String getName() { return name; }

    public void attack(Character target) {
        int totalDamage = this.damage + weapon.getDamage();
        System.out.println(this.name + " (" + this.type + ") attacks " + target.getName() + " with " + weapon.getName() + "!");
        target.receiveDamage(totalDamage);
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
}