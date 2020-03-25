
package States;

import Entities.EntityManager;
import Graficos.Assets;
import Main.Game;
import Main.Handler;
import java.awt.Graphics;

/**
 *
 * @author German David
 */
public class MenuState extends State{

    public MenuState(Game game,Handler handler) {
        super(game,handler);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
       g.drawImage(Assets.background, 0, 0, null);
    }

    
}
