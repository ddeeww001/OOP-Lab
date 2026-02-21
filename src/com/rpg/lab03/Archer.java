package com.rpg.lab03;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int maxHp, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon);
        this.type = "Archer";
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Character target) {
        int totalDamage = this.damage + weapon.getDamage();
        System.out.println(this.name + " fires a precise shot at " + target.getName() + "!");
        target.receiveDamage(totalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " (" + type.toUpperCase() + ") ---");
        System.out.println("Status: " + (hp > 0 ? "Active" : "Defeated"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
         }
}