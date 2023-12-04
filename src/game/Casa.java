/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import static game.Sprite.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Usuario
 */
public class Casa extends Sprite{
    
    public static int width = 60;
    public static int height = 20;
    Thread m;

    public Casa(int x, int y) {
        super(x, y, width, height);
        m=new MoveDecor(this);
        m.start();
    }

    

    @Override
    public void draw(Graphics g) {
       // Configura el color
       Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\183437938-house-facade-pixelated-style-icon__1_-removebg-preview (1).png");
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, getX(), getY(), null);
            }
        
    }
    
}

