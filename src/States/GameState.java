/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Entities.Creatures.Player;
import Entities.Items.Bullet;

import Graficos.Assets;
import Main.Game;
import java.awt.Graphics;


public class GameState extends State{

    private Player player;
    private Bullet[] bulls;
    
    public GameState(Game game) {
        super(game);
        player= new Player( this.game,100,100);
        
    }

    
    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0,800,600, null);
        player.render(g);
        
    }

    
    
}
