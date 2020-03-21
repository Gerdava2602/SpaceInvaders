/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author German David
 */
public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }
    
    //131x110 son las medida de cada sprite
    public BufferedImage crop(int x, int y, int width,int height){
        return sheet.getSubimage(x, y, width, height);
    }
    
}
