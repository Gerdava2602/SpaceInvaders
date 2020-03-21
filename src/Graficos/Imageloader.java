/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author German David
 */
public class Imageloader {
    
     public static BufferedImage loadImage(String path){
         try {
             return ImageIO.read(Imageloader.class.getResource(path));
         } catch (IOException ex) {
             System.exit(1);
         }
         return null;
     }
    
}
