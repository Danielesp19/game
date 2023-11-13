/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuario
 */
public class Fondo extends Sprite implements Drawable{
    private final pj pj1;
    private Drawable drawable;
    
    public Fondo(int x, int y, int width, int height) {
        super(x, y, width, height);
        pj1=new pj(width/2, height-90);
    }

    @Override
    public void draw(Graphics g) {
        Image carImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\fondo.jpg");

        
        if(carImage != null){
            g.drawImage(carImage, getX(), getY(), null);
        }
         
        
        pj1.draw(g);
        
        
    }
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    /**
     *
     */
    @Override
    public void redraw() {
        drawable.redraw();
    }
    public void handleKey(int key)
    {
        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
        {
            pj1.move(key);
            redraw();
            
              // TODO
        }
    }
}
