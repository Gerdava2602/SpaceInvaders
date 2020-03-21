/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Input.KeyManager;
/**
 *
 * @author German David
 */
public class Handler {
    
    private Game game;
    
    public Handler (Game game){
        this.game=game;
    }
    
    public int getWidth(){
        return game.getWidth();
    }
    
    public int getHeight(){
        return game.getHeight();
    }
    
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    
    
}
