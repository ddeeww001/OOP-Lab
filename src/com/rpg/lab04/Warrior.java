package com.rpg.lab04;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHp, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Character target) {
        int baseDamage = this.damage + weapon.getDamage();
        int totalDamage = (int) (baseDamage * 1.5);

        String targetName = (target instanceof Character) ? ((Character)target).getName() : "Target";
        System.out.println(this.name + " (Warrior) performs a POWERFUL STRIKE on " + targetName + "!");
        System.out.println("Base Damage: " + baseDamage + " → Enhanced: " + totalDamage + " (1.5x multiplier)");

        target.takeDamage(totalDamage);
    }
    @Override
    public void takeDamage(int amount) {
        int damageAfterArmor = amount - armorValue;
        if (damageAfterArmor < 0) damageAfterArmor = 0;
        int finalDamage = damageAfterArmor - defense;
        if (finalDamage < 0) finalDamage = 0;

        System.out.println(name + "'s Armor: " + armorValue + " (reduces damage from " + amount + " to " + damageAfterArmor + ")");
        System.out.println(name + "'s Defense: " + defense + " (reduces damage from " + damageAfterArmor + " to " + finalDamage + ")");
        System.out.println("Actual Damage Taken: " + finalDamage);

        this.hp = Math.max(0, this.hp - finalDamage);
        System.out.println(name + "'s HP: " + hp + "/" + maxHp);
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
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");

    }


}