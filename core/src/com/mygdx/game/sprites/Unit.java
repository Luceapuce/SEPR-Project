package com.mygdx.game.sprites;

public abstract class Unit extends TestEntity { //needs to be changed to extend entity
    private int maxHealth;
    private int currentHealth;
    private int range;

    public Unit() {
        super();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getRange() {
        return range;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean is_dead() {
        if(this.currentHealth == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
