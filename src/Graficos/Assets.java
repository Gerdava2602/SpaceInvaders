/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;

//every image, music or resource
public class Assets {

    public static BufferedImage rocket[]=new BufferedImage[3],empty,misil,background;

    private static final int width = 123, height = 52;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(Imageloader.loadImage("/Textures/space.png"));
        for (int i = 0; i < 2; i++) {     
            rocket[i]=sheet.crop(123*i, 0, 123, 52);
        }
        background = Imageloader.loadImage("/Textures/espacio.png");
        misil= Imageloader.loadImage("/Textures/misil.png");
    }
}