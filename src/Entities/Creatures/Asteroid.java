/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Creatures;

import Entities.Entity;
import Entities.EntityManager;
import Graficos.Assets;
import Main.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author German David
 */
public class Asteroid extends Creature{
    

    
    public Asteroid(Handler handler,EntityManager manager, float x, float y, int width, int height) {
        super(handler,manager, x, y,width,height);
        
         this.width=(int)(Math.random()*70+30);
         this.height=this.width;
         Xmove=(int)(Math.random()*3+1);
         
         bounds.x=0;
         bounds.y=0;
         bounds.width=this.width;
         bounds.height=this.height;
    }

    @Override
    public void die() {
      
    }

    @Override
    public void update() {
        move();
        checkAttacks();
    }
    
    @Override
    public void move(){
        x-=Xmove;
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.asteroid,(int) x, (int)y,width,height, null);
    }
    
    public void checkAttacks(){
        Rectangle cb= getCollisionBounds();
        
        
        for (Entity e : manager.getEntities() ) {
            if(!e.equals(this)){ 
                if(e.getCollisionBounds().intersects(cb)){
                    //Por si son asteorides, se destruye el mas pequeño
                    if((e instanceof Asteroid )){
                       if(e.getWidth()*e.getHeight()>this.getWidth()*this.getHeight())
                           this.setActive(false);
                            else
                                e.setActive(false);
                    }else{
                        //Si no es un asteroide, le hace 5 de daño
                        System.out.println("Golpeó con"+e);
                        e.hurt(5);
                        this.setActive(false);
                    }
                }
            }
        }
    }
}
