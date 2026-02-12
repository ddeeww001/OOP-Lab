package om.rpg.lab01;
/*
public class Healer extends Character {
    private int healingPoint;


    public int getHealingPoint() {
        return healingPoint + (getLevel()*2);
    }

    public void setHealingPoint(int healingPoint) {
        this.healingPoint = healingPoint;
    }

    public Healer(String name, int level, int maxHealthPoint, int baseDamage, int defense, Weapon weapon, int healingPower) {
        // ส่งค่าไปให้ Character (Class แม่) โดยกำหนด Class Name เป็น "Healer"
        super(name, level, maxHealthPoint, baseDamage, defense, weapon, "Healer");
        this.healingPower = healingPower;
    }

    public void heal() {
        int amount = healingPower + (level * 3); // สูตรสมมติ: Base + Level Bonus
        int oldHp = this.healthPoint;
        this.healthPoint = Math.min(this.maxHealthPoint, this.healthPoint + amount);

        System.out.println(name + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + amount);
        System.out.println("Restored " + (this.healthPoint - oldHp) + " HP! Current HP: " + healthPoint + "/" + maxHealthPoint);
    }

    public void healAlly(Character ally) {
        int amount = healingPower + (level * 3);
        int oldHp = ally.healthPoint;
        ally.healthPoint = Math.min(ally.maxHealthPoint, ally.healthPoint + amount); // เข้าถึง field ได้เพราะเป็น protected ใน package เดียวกัน

        System.out.println(name + " (Healer) casts healing spell on " + ally.name + "!");
        System.out.println("Healing Amount: " + amount);
        System.out.println("Restored " + (ally.healthPoint - oldHp) + " HP to " + ally.name + "! Their HP: " + ally.healthPoint + "/" + ally.maxHealthPoint);
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("\n--- " + this.getName().toUpperCase() + " ---");
        System.out.println("  Class: " + this.getCharacterClass());
        System.out.println("  Level: " + this.getLevel());
        System.out.println("  Health Points: " + this.getHealthPoint() + "/" + this.getMaxHealthPoint());
        System.out.println("  Weapon: " + this.getWeapon().toString());
        System.out.println("  Healing Power: " + getHealingPoint());
    }


}

*/