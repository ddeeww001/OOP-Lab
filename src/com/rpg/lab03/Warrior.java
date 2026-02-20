package com.rpg.lab03;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHp, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon);
        this.type = "Warrior";
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Character target) {
        int totalDamage = (int) ((this.damage + weapon.getDamage()) * 1.5); // 1.5x multiplier
        System.out.println(this.name + " uses a heavy strike on " + target.getName() + "!");
        target.receiveDamage(totalDamage);
    }

    @Override
    public void receiveDamage(int amount) {
        // Reduces incoming damage by armor before standard defense calculation
        int reducedDamage = amount - armorValue;
        if (reducedDamage < 0) reducedDamage = 0;
        super.receiveDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Armor Value: " + armorValue);
    }
}