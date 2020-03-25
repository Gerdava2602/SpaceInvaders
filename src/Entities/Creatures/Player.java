/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Creatures;

import Entities.EntityManager;
import Entities.Items.Bullet;
import Graficos.Assets;
import Main.Game;
import Main.Handler;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author German David
 */
public class Player extends Creature {

    public Bullet[] bullets= new Bullet[100];
    public static int bullcount = 0;
    private long clock,now=0;
    private float ShootSpeed= 0.3f;

    public Player(Handler handler,EntityManager manager ,float x, float y) {
        super(handler,manager, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATUR_HEIGHT);
        
        bounds.x=48;
        bounds.y=0;
        bounds.width=70;
        bounds.height=52;
    }

    @Override
    public void update() {
        clock=System.nanoTime();
        getInput();
        move();
        for (int i = 0; i <100; i++) {
            //condición para que no se borren las balas ya hechas
            if(bullets[i] != null ){
            bullets[i].update();
            }
        }
        
    }

    @Override
     public void move(){
      
        x +=Xmove;
        if(x+bounds.width<0)
            x=-bounds.width;
        if(x+bounds.width>handler.getGame().getWidth())
            x=handler.getGame().getWidth()-bounds.width;
            y+=Ymove;
        if(y<0)
            y=1;
        if(y+bounds.height>handler.getGame().getHeight())
            y=handler.getGame().getHeight()-bounds.height;
    }
    
    private void getInput() {
        Xmove = 0;
        Ymove = 0;

        if (handler.getGame().getKeyManager().up) {
            Ymove = -speed;
        }

        if (handler.getGame().getKeyManager().down) {
            Ymove = speed;
        }

        if (handler.getGame().getKeyManager().right) {
            Xmove = speed;
        }
        if (handler.getGame().getKeyManager().left) {
            Xmove = -speed;
        }
        if (handler.getGame().getKeyManager().space && canShoot(clock-now)) {
            bullets[bullcount] = new Bullet(this.handler,manager, x, y, Player.DEFAULT_CREATURE_WIDTH, Player.DEFAULT_CREATUR_HEIGHT);
            manager.addEntity(bullets[bullcount]);
            bullcount++;
            if(bullcount==100){
                bullcount=0;
            }
            System.out.println(""+bullcount);
        }

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentImage(), (int) (x), (int) (y ), null);
        
        for (int i = 0; i < 100; i++) {
           if(bullets[i]!= null){ 
            bullets[i].render(g);
           }
        }
        
    }
    
    public boolean canShoot(long c){
        if((double)c/1000000000>=ShootSpeed){
            System.out.println(""+(double)c/1000000000);
          now=clock;         
          return true;
        }else{
            return false;
        }
    }

    public float getShootSpeed() {
        return ShootSpeed;
    }

    public void setShootSpeed(float ShootSpeed) {
        this.ShootSpeed = ShootSpeed;
    }

    @Override
    public void die() {
        System.out.println("You lose");
    }
    
    private BufferedImage getCurrentImage(){
        if(Xmove>0){
            return Assets.rocket[0];
        }else if(Xmove<0){
            return Assets.rocket[2];
        }else{
            return Assets.rocket[1];
        }
    }
    
}
