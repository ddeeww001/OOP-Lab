package com.rpg.lab04;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int maxHp, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }


    public void attack(Destructible target) {
        int baseDmg = 40;
        int rangeBonus = 12;
        int totalDmg = baseDmg + rangeBonus;

        String targetName = (target instanceof Character) ? ((Character)target).getName() : "Target";
        System.out.println(name + " (Archer) shoots a precise arrow at " + targetName + "!");
        System.out.println("Base Damage: " + baseDmg + " + Range Bonus: " + rangeBonus + " = " + totalDmg);
        System.out.println("Accuracy: " + accuracy + "% (HIT!)");

        target.takeDamage(totalDmg);
    }
    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount - defense;
        if (actualDamage < 0) actualDamage = 0;
        System.out.println(name + "'s Defense: " + defense + " (reduces damage from " + amount + " to " + actualDamage + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);

        this.hp = Math.max(0, this.hp - actualDamage);
        System.out.println(name + "'s HP: " + hp + "/" + maxHp);
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