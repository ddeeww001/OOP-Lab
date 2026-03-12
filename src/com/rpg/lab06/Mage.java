package com.rpg.lab06;

public class Mage extends Character implements Destructible {
    private int mana, maxMana;



    public Mage(String name, int level, int maxHp, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHp, damage, defense, weapon, "Mage");
        this.mana = mana; this.maxMana = mana;
    }

    @Override
    public void attack(Destructible target) {
        if(mana < 30) {
            System.out.println(name + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println("Current Mana: " + mana + "/" + maxMana + " (Need: 30)");
            return;
        }
        int spellDamage = 40 + 10;
        mana -= 30;
        String targetName = (target instanceof Character) ? ((Character)target).getName() : "Target";
        System.out.println(name + " (Mage) casts MAGIC MISSILE at " + targetName + "!");
        System.out.println("Spell Damage: " + spellDamage + " (Base: 40 + Spell Bonus: 10)");
        System.out.println("Mana Used: 30 | Remaining: " + mana + "/" + maxMana);

        target.takeDamage(spellDamage);
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
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

}