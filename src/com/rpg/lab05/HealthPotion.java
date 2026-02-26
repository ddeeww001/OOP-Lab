package com.rpg.lab05;

public class HealthPotion implements Consumable {
    private String name;
    private int healAmount, quantity;

    public HealthPotion(String name, int healAmount, int quantity) {
        this.name = name; this.healAmount = healAmount; this.quantity = quantity;
    }

    @Override
    public void use(Character user) {
        if (quantity > 0) {
            System.out.println(user.getName() + " drinks " + name + "!");
            int oldHp = user.getHp();
            user.heal(healAmount);
            System.out.println("Health restored: " + oldHp + " → " + user.getHp() + " (+" + healAmount + ")");
            quantity--;
            System.out.println(name + " remaining: " + quantity);
        }
    }

    public void displayPotionDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Healing Power: " + healAmount + " HP\nQuantity: " + quantity + "\nType: Consumable");
    }
}