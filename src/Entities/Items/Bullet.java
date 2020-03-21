/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Items;


import Entities.Creatures.Player;
import Entities.Entity;
import Graficos.Assets;
import Main.Game;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author German David
 */
public class Bullet extends Entity {
    
    private int X;
    private int Y;
    
    public Bullet(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        X=(int) (x+Player.DEFAULT_CREATURE_WIDTH/2 );
        Y=(int) ( Player.DEFAULT_CREATUR_HEIGHT/2 + y );
    }
    
    
    
    @Override
    public void update() {
       
        X+=5;
        
      
    }

    @Override
    public void render(Graphics g) {
        if(X <= game.getWidth()){
         g.drawImage(Assets.misil, X, Y, null);
        }
    }

    
    
    public boolean isShoot(){
        if(x>=game.getWidth()){
            return false;
        }else{
            return true;
        }
    }
    
}
