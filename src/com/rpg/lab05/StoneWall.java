package com.rpg.lab05;

public class StoneWall implements Destructible {
    private String location, type;
    private int hp, maxHp;

    public StoneWall(String location, int hp, String type) {
        this.location = location; this.hp = hp; this.maxHp = hp; this.type = type;
    }
    public String getLocation() { return location; }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        System.out.print(location + " takes " + amount + " damage! (Durability: " + hp + "/" + maxHp + ")\n");
        if (hp <= 0) System.out.println(location + " has CRUMBLED to pieces!");
    }

    @Override
    public boolean isDestroyed() { return hp <= 0; }

    public void displayWallDetails() {
        System.out.println("--- " + location.toUpperCase() + " ---");
        System.out.println("Type: " + type + "\nStatus: " + (isDestroyed() ? "DESTROYED" : "STANDING") + "\nDurability: " + Math.max(0, hp) + "/" + maxHp);
    }
}