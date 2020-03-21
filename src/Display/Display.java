/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author German David
 */
public class Display {
    //la ventana
    private JFrame frame;
    //canva para dibujar en el
    private Canvas canvas;
    //titulo
    private String titulo;
    //alto y ancho de la ventana
    private int width,height;

    public Display(String titulo, int width, int height) {
        this.titulo = titulo;
        this.width = width;
        this.height = height;
        
        createDisplay();
    }
    private void createDisplay(){
        frame=new JFrame(titulo);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        // no se puede cambiar el tamaño de la ventana
        frame.setResizable(false);
        //Para que aparezca la ventana en el medio;
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas= new Canvas();
        //para que el canva se quede en el espacio de la ventana asignado
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        //The only thing that can be focused is the frame
        canvas.setFocusable(false);
        
        frame.add(canvas);
        //ajusta la ventana para que se vea todo el canva
        frame.pack();
    }
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
