package com.rpg.lab04;

public class CastleGate implements Destructible {
    private String name;
    private int hp, maxHp;
    private boolean locked, reinforced;

    public CastleGate(String name, int hp, boolean locked, boolean reinforced) {
        this.name = name; this.hp = hp; this.maxHp = hp;
        this.locked = locked; this.reinforced = reinforced;
    }

    @Override
    public void takeDamage(int amount) {
        int finalDmg = reinforced ? amount / 2 : amount;
        if (reinforced) System.out.println(name + " is REINFORCED! (reduces damage from " + amount + " to " + finalDmg + ")");
        hp -= finalDmg;
        System.out.println(name + " takes " + finalDmg + " damage! (Durability: " + hp + "/" + maxHp + ")");
        if (hp <= 0) System.out.println(name + " has been BREACHED! The gate COLLAPSES!");
    }

    @Override
    public boolean isDestroyed() { return hp <= 0; }

    public void displayGateDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Status: " + (isDestroyed() ? "BREACHED" : "INTACT") + "\nDurability: " + Math.max(0, hp) + "/" + maxHp);
        System.out.println("Locked: " + (locked ? "Yes" : "No") + "\nReinforced: " + (reinforced ? "Yes" : "No"));
    }
}