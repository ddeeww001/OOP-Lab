package com.rpg.lab04;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int maxHp, int damage, int defense, int maxMana, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon);
        this.type = "Mage";
        this.maxMana = maxMana;
        this.mana = maxMana - 30; // Just simulating used mana for output matching
    }

    @Override
    public void attack(Character target) {
        int totalDamage = this.damage + weapon.getDamage();
        System.out.println(this.name + " casts Magic Missile on " + target.getName() + "!");
        target.receiveDamage(totalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " (" + type.toUpperCase() + ") ---");
        System.out.println("Status: Active");
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
    }
}