package com.rpg.lab03;

public class Healer extends Character {
    private int baseHealingPower;

    public Healer(String name, int level, int maxHp, int damage, int defense, Weapon weapon, int baseHealingPower) {
        super(name, level, maxHp, damage, defense, weapon, "Healer");
        this.baseHealingPower = baseHealingPower;
    }

    public int getHealingPower() {
        return baseHealingPower + (level * 3);
    }

    public void heal() {
        int healAmount = getHealingPower();
        super.heal(healAmount);

        System.out.println(this.name + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount + " (Base: " + baseHealingPower + " + Level Bonus: " + (level * 3) + ")");
        System.out.println("Restored " + healAmount + " HP! Current HP: " + this.hp + "/" + this.maxHp);
    }

    public void healAlly(Character ally) {
        int healAmount = getHealingPower();
        ally.heal(healAmount);

        System.out.println(this.name + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("Healing Amount: " + healAmount);
        System.out.println("Restored " + healAmount + " HP to " + ally.getName() + "! Their HP: " + ally.hp);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Healing Power: " + getHealingPower());
    }
}