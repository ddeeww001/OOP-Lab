package com.rpg.lab06;

public class WoodenBox implements Destructible {
    private String name;
    private int hp, maxHp;
    private boolean locked;
    private String contents;

    public WoodenBox(String name, int hp, boolean locked, String contents) {
        this.name = name; this.hp = hp; this.maxHp = hp;
        this.locked = locked; this.contents = contents;
    }

    public String getName() { return name; }

    @Override
    public void takeDamage(int amount) {
        System.out.println(name + " takes " + amount + " damage!");
        this.hp = this.hp - amount;
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(name + " is now DESTROYED!");
        }
        System.out.println(name + " HP: " + hp + "/" + maxHp + (hp == 0 ? " (DESTROYED!)" : ""));
    }

    @Override
    public boolean isDestroyed() { return hp <= 0; }

    // 🌟 เพิ่มเมธอดนี้เข้ามาเพื่อให้ Main เรียกใช้ได้
    public void breakOpen() {
        if (isDestroyed()) {
            if (locked) System.out.print("The lock broke! ");
            System.out.println(name + " breaks open!\nContents revealed: " + contents);
        } else {
            System.out.println("Cannot break open " + name + " - it's still intact!");
        }
    }

    // 🌟 เพิ่มเมธอดนี้เข้ามาเพื่อให้ Main เรียกใช้ได้
    public void displayBoxDetails() {
        System.out.println("--- " + name.toUpperCase() + " (WOODEN BOX) ---");
        System.out.println("Status: " + (isDestroyed() ? "Destroyed" : "Intact"));
        System.out.println("Health: " + hp + "/" + maxHp + "\nLocked: " + (locked ? "Yes" : "No") + "\nContains: " + contents);
    }
}