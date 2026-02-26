package com.rpg.lab04;

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
        super.displayCharacterDetails();
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
        }
    }
}