/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Entities.Creatures.Player;
import Entities.EntityManager;
import Entities.Items.Bullet;

import Graficos.Assets;
import Main.Game;
import Main.Handler;
import World.World;
import java.awt.Graphics;


public class GameState extends State{

    
    private EntityManager manager;
    private Player player;
    private World world;
    
    public GameState(Game game,Handler handler) {
        super(game,handler);
        
        manager= new EntityManager (handler,player);
        
        world = new World(manager,handler);
    }

    
    @Override
    public void update() {
        world.update();
        manager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0,800,600, null);
        world.render(g);
        manager.render(g);
    }

}
