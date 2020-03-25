/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Graficos.Imageloader;
import Display.Display;
import Entities.Creatures.Player;
import Entities.EntityManager;
import Graficos.Assets;
import Graficos.SpriteSheet;
import States.GameState;
import States.MenuState;
import States.State;
import Input.KeyManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German David
 */
//va a ser la que haga todo lo de juego
public class Game implements Runnable {
//la pantalla
    private Display display;

//size
    private int width, height;

// Hilo en el que se desarrolla;
    private Thread thread;

//variable para que corra el juego
    private boolean running = false;

// titulo del juego
    public String titulo;

//A way to the computer how to draw things. A buffer is a Hidden "Screen" on your computer
//Explicacion en : https://www.youtube.com/watch?v=Idb6-Zfdq2Q&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=5&frags=wn min 4:25
//Es usado para dar una imagen mas estable al juego    
    private BufferStrategy bs;
//
    private Graphics g;
    public int ticks;
//States
    private State gameState;
    private State menuState;
    private State SettingState;
    
    //Input
    private KeyManager KeyManager;
    //Handler
    private Handler handler;
    //
    private Player player;
    
    //Constructor
    public Game(String titulo, int width, int height) {
        this.height = height;
        this.width = width;
        this.titulo = titulo;
        
        KeyManager= new KeyManager();
        handler= new Handler(this);
       
    }

    //Inicio
    private void init() {

        display = new Display(titulo, width, height);
        display.getFrame().addKeyListener(KeyManager);
        
        //Create all the images from the begin
        Assets.init();
        


        gameState= new GameState(this,handler);
        menuState= new MenuState(this,handler);
        State.setState(gameState);
    }

   

    //actualiza las variables
    private void update() {
        KeyManager.update();
       if(State.getState() != null){
         
           State.getState().update();
           
       }
    }

    // draw things on the screen
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            //numero de buffers, si ya no hay
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //limpia la pantalla
        g.clearRect(0, 0, width, height);
        
        //Dibuja desde aqui
        
        if(State.getState()!=null){
            State.getState().render(g);
        }
        
        
        //Donde termina de pintar
        bs.show();
        //Hace que se cierre nuestro graphic object
        g.dispose();
    }

    @Override
    public void run() {
        init();

        //frames per second
        int fps = 60;
        //there are 1 million nanoseconds on a second
        double timePerUpd = 1000000000 / fps;

        double delta = 0;

        long now;
        //the current time of the computer on nanos
        long lastTime = System.nanoTime();
        // se utilizan para medir los fps
        long timer=0;
         int ticks=0;
    
        while (running) {
            now = System.nanoTime();
            //Amount of time passed and divide it by the maximum amount of time
            delta += (now - lastTime) / timePerUpd;
            timer += now-lastTime;
            lastTime = now;
            
            if (delta>=1) {
                update();
                render();
                // se le aumenta a los fps
                ticks++;
                //vuelve a iniciar el delta
                delta--;
            }
            //esto se hace cuando pasa un segundo
            if(timer >= 1000000000){
                System.out.println("ticks and frames:"+ticks);
                //reinicia el contador y los fps para ver si el juego lo hace constantemente
                ticks=0;
                timer=0;
            }
        }

        stop();
    }

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    public State getSettingState() {
        return SettingState;
    }

    public void setSettingState(State SettingState) {
        this.SettingState = SettingState;
    }
    
    public KeyManager getKeyManager(){
        return KeyManager;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
    //synchronized se usa cuando se usa hilos y quieres que todo vaya en orden
    public synchronized void start() {
        //por si el juego ya inició
        if (running == true) {
            return;
        }
        running = true;
        thread = new Thread(this);
        //para que corra
        thread.start();

    }

    public synchronized void stop() {
        // por si el juego ya paró
        if (running == false) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
