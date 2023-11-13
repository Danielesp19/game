/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuario
 */
public class pj extends Sprite{
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    public static final int STEP = 20;
    private Drawable drawable;
    
    

    public pj(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        
    }
   
    public void move(int key){ 
        if(key == KeyEvent.VK_LEFT)
            x -= STEP;
        if(key == KeyEvent.VK_RIGHT)
            x += STEP;
        
    }
    
}
