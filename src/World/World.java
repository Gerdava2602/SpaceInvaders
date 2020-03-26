/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Entities.Creatures.Asteroid;
import Entities.Entity;
import Entities.EntityManager;
import Graficos.Assets;
import Main.Handler;
import java.awt.Graphics;

/**
 *
 * @author German David
 */
public class World {
    private EntityManager manager;
    private Handler handler;

    public World(EntityManager manager,Handler handler) {
        this.manager = manager;
        this.handler= handler;
        
        
        
    }
    
    public void update(){
        int j=0;
        for (Entity e : manager.getEntities()) {
            if(e instanceof Asteroid)
                j++;
        }
        if(j<8){
            for (int i=j; i <= 8; i++) {
                manager.addEntity(new Asteroid(handler,manager,800, (float) (Math.random()*550+50),100,100));
            }
        }
        manager.update();
        
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.background, 0, 0,800,600,null);
        manager.render(g);
    }
    
}
