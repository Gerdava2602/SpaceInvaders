
package States;

import Graficos.Assets;
import Main.Game;
import java.awt.Graphics;

/**
 *
 * @author German David
 */
public class MenuState extends State{

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
       g.drawImage(Assets.background, 0, 0, null);
    }

    
}
