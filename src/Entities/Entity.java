/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import Main.Game;
import java.awt.Graphics;

/**
 *
 * @author German David
 */
public abstract class Entity {
    protected Game game;
    //posición
    protected float x,y;
    protected int width,height;

    public Entity(Game game,float x, float y,int width, int height) {
        this.game=game;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
