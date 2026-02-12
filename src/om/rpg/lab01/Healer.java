package om.rpg.lab01;

public class Healer extends Character {
    private int healingPower;
    private int healthPoint;
    private int maxHealthPoint;
    private  boolean checkpoint = true;
    public int getHealingPower() {
        healingPower += getLevel();
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }


    public Healer(String name, int level, int maxHealthPoint, int defense,int damage, Weapon weapon, int healingPower) {
        // ส่งค่าไปที่ Constructor ของแม่ (Character)
        super(name, level, maxHealthPoint, defense,damage, weapon, "Healer");
        this.healingPower = healingPower;
    }

    public void heal() {/*
        this.heal(healingPower);
        System.out.println(this.getName() + " (Healer) cast a healing spell!");
        System.out.println("   Healing Amount: " + getHealingPower() + " (Base: " + getHealingPower() + " + Level Bonus: " + (getLevel()*2) + ")");
        System.out.println("   Restored "+ getHealingPower() + " HP! Current HP: " + this.getHealthPoint() + "/" + this.getMaxHealthPoint());
        */
        int amount = healingPower + (getLevel() * 3);
        this.healthPoint += amount;
        if (this.healthPoint > this.maxHealthPoint) {
            this.healthPoint = this.maxHealthPoint;
        }
        System.out.println("\n" + getName() + " (Healer) casts a healing spell!");
        System.out.println("Restored " + amount + " HP! Current HP: " + healthPoint + "/" + maxHealthPoint);
    }

    public void healAlly(Character ally) {
        int amount = healingPower + (getLevel() * 3);
        ally.heal(getHealingPower());
        if(checkpoint){
            System.out.println(this.getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
            System.out.println("   Healing Amount: " + amount+ " (Base: "+healingPower+"  Level Bonus: "+(getLevel()*3) );
            System.out.println("   Restored "+ amount + " HP to " + ally.getName() + "! Their HP: " + ally.getHealthPoint());
        }

        System.out.println(this.getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("   Healing Amount: " + amount);
        System.out.println("   Restored "+ amount + " HP to " + ally.getName() + "! Their HP: " + ally.getHealthPoint());
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("\n--- " + this.getName().toUpperCase() + " ---");
        System.out.println(" Class: " + this.getCharacterClass());
        System.out.println(" Level: " + this.getLevel());
        System.out.println(" Health Points: " + healthPoint+ "/" + maxHealthPoint);
        System.out.println(" Damage: "+getDamage());
        System.out.println(" Defense: "+getDefense());
        System.out.println(" Weapon: " + this.getWeapon().toString());
        System.out.println(" Healing Power: "+healingPower);
    }

    @Override
    public int getHealthPoint() {
        return healthPoint;
    }

    @Override
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    @Override
    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }


}