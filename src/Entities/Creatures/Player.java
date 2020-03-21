/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Creatures;

import Entities.Items.Bullet;
import Graficos.Assets;
import Main.Game;


import java.awt.Graphics;

/**
 *
 * @author German David
 */
public class Player extends Creature {

    public Bullet[] bullets= new Bullet[100];
    public static int bullcount = 0;
    private long clock,now=0;
    

    public Player(Game game, float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATUR_HEIGHT);
        
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

    private void getInput() {
        Xmove = 0;
        Ymove = 0;

        if (game.getKeyManager().up) {
            Ymove = -speed;
        }

        if (game.getKeyManager().down) {
            Ymove = speed;
        }

        if (game.getKeyManager().right) {
            Xmove = speed;
        }
        if (game.getKeyManager().left) {
            Xmove = -speed;
        }
        if (game.getKeyManager().space && canShoot(clock-now)) {
            bullets[bullcount] = new Bullet(this.game, x, y, Player.DEFAULT_CREATURE_WIDTH, Player.DEFAULT_CREATUR_HEIGHT);
            bullcount++;
            if(bullcount==100){
                bullcount=0;
            }
            System.out.println(""+bullcount);
        }

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.rocket[0], (int) (x), (int) (y ), null);
        
        for (int i = 0; i < 100; i++) {
           if(bullets[i]!= null){ 
            bullets[i].render(g);
           }
        }
        
    }
    
    public boolean canShoot(long c){
        if(c/1000000000>=0.5){
          now=clock;         
          return true;
        }else{
            return false;
        }
    }
}
