/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Creatures;

import Entities.Entity;
import Main.Game;
import java.awt.Graphics;

/**
 *
 * @author German David
 */
public abstract class Creature extends Entity{
    
    protected float Xmove=0,Ymove=0;
    protected int health;
    protected float speed;
    
    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=2.0f;
    public static final int DEFAULT_CREATURE_WIDTH=131;
    public static final int DEFAULT_CREATUR_HEIGHT=110;
    
    
    public Creature(Game game,float x, float y,int width, int height) {
        super(game,x,y,width,height);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
    }

    public void move(){
        x +=Xmove;
        y+=Ymove;
    }
//Getters and setters
    public float getXmove() {
        return Xmove;
    }

    public void setXmove(float Xmove) {
        this.Xmove = Xmove;
    }

    public float getYmove() {
        return Ymove;
    }

    public void setYmove(float Ymove) {
        this.Ymove = Ymove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    
}
