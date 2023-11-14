/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import static game.Sprite.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuario
 */
public class pj extends Sprite implements Drawable{
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    public static final int STEP = 20;
    private Drawable drawable;
    
    

    public pj(int x, int y,int WIDTH,int HEIGHT) {
        super(x, y, WIDTH, HEIGHT);
    }
    
    @Override
    public void draw(Graphics g) {
        Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\Firefly_dame_la_imagen_de_un_carro_tipo_juego_visto_desde_arriba_que_mire_hacia_atras_simple_17639-removebg-preview (1).png");
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, getX(), getY(), null);
        }
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

    @Override
    public void redraw() {
            drawable.redraw();
    }
    
}
