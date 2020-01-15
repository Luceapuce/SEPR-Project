package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.audio.Sound;

public class Firetruck extends Character {

    private int maxWater;
    private int currentWater;
    private boolean selected;

    // Constructor
    public Firetruck(Vector2 position, int width, int height, Texture texture, int maxHealth, int range, Unit target,
                     int speed, int dps, int bearing, int maxWater, boolean selected, float attackCooldown) {
        super(position, width, height, texture, maxHealth, range, target, speed, dps, attackCooldown);
        this.maxWater = maxWater;
        this.currentWater = maxWater;
        this.selected = selected;
    }

    // Getters and Setters
    public int getMaxWater() {
        return maxWater;
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    public void updateCurrentWater(int waterUsed) {
        this.currentWater -=  waterUsed;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public void move(int direction) { //change from string to 1, 2, 3, 4
        float deltaTime = Gdx.graphics.getDeltaTime();
        if (direction == 2) {
            setPosition(getPosition().x + getSpeed() * deltaTime, getPosition().y);
        } else if (direction == 1) {
            setPosition(getPosition().x - getSpeed() * deltaTime, getPosition().y);
        } else if (direction == 3) {
            setPosition(getPosition().x, getPosition().y + getSpeed() * deltaTime);
        } else if (direction == 4) {
            setPosition(getPosition().x, getPosition().y - getSpeed() * deltaTime);
        }
    } // 1, 2, 3, 4 --> Left, Right, Up, Down

    public boolean willCollide(Entity other, int direction) {
        if (direction == 3) { // up
            if (getPosition().y >= other.getTopRight().y || getTopRight().y + getSpeed() * Gdx.graphics.getDeltaTime()<= other.getPosition().y ||
                    getPosition().x >= other.getTopRight().x || getTopRight().x <= other.getPosition().x) {
                return false;
            }
        } else if (direction == 4) { // down
            if (getPosition().y - getSpeed() * Gdx.graphics.getDeltaTime() >= other.getTopRight().y || getTopRight().y <= other.getPosition().y ||
                    getPosition().x >= other.getTopRight().x || getTopRight().x <= other.getPosition().x) {
                return false;
            }
        } else if (direction == 2) { // right
//            System.out.println("-------------");
//            System.out.println(getTopRight().x + getSpeed());
//            System.out.println(other.getPosition().x);
//            System.out.println("------");
//            System.out.println(getPosition().x);
//            System.out.println(other.getTopRight().x);
//            System.out.println("------");
//            System.out.println(getPosition().y);
//            System.out.println(other.getTopRight().y);
//            System.out.println("------");
//            System.out.println(getTopRight().y);
//            System.out.println(other.getPosition().y);
//            System.out.println("-------------");
            if ((getTopRight().x + getSpeed() * Gdx.graphics.getDeltaTime() <= other.getPosition().x || getPosition().x >= other.getTopRight().x ||
                    getPosition().y >= other.getTopRight().y || getTopRight().y <= other.getPosition().y)) {
                return false;
            }
        } else if (direction == 1) { // left
            if (getPosition().x - getSpeed() * Gdx.graphics.getDeltaTime() >= other.getTopRight().x || getTopRight().x <= other.getPosition().x ||
                    getPosition().y >= other.getTopRight().y || getTopRight().y <= other.getPosition().y) {
                return false;
            }
        }
        return true;
    }
}