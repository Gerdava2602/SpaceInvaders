/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Items;


import Entities.Creatures.Player;
import Entities.Entity;
import Entities.EntityManager;
import Graficos.Assets;
import Main.Game;
import Main.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author German David
 */
public class Bullet extends Entity {
    
    private int X;
    private int Y;
    private int BulletSpeed=8;
    
    public Bullet(Handler handler,EntityManager manager, float x, float y, int width, int height) {
        super(handler,manager, x, y, width, height);
        X=(int) (x+Player.DEFAULT_CREATURE_WIDTH/2 );
        Y=(int) ( Player.DEFAULT_CREATUR_HEIGHT/2 + y );
        
        bounds.x=2;
        bounds.y=0;
        bounds.width=this.height;
        bounds.height=this.width;
    }
    
    
    
    @Override
    public void update() {
       
        X+=BulletSpeed;
        checkAttacks();
      
    }

    @Override
    public void render(Graphics g) {
        if(X <= handler.getGame().getWidth()){
         g.drawImage(Assets.misil, X, Y, null);
        }
    }

    
    
    

    public int getBulletSpeed() {
        return BulletSpeed;
    }

    public void setBulletSpeed(int BulletSpeed) {
        this.BulletSpeed = BulletSpeed;
    }

    @Override
    public void die() {
        
    }
    
    public void checkAttacks(){
        Rectangle cb=getCollisionBounds(0,0);
        
        for (Entity e : manager.getEntities()) {
            if(!e.equals(this) && !(e instanceof Player)){
                if(e.getCollisionBounds(0, 0).intersects(cb)){
                    e.hurt(1);
                    this.hurt(5);
                }
            }
        }
    }
    
}
