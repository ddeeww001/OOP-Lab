package com.rpg.lab06;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHp, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
        setAttack(new WarriorStyleDecorator(getAttack()));
    }

    // 🌟 จุดสำคัญ: เปลี่ยนพารามิเตอร์เป็น Destructible target
    @Override
    public void attack(Destructible target) {
        super.attack(target);
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
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Armor Value: " + armorValue);
        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
        }
    }
}