/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemigos;

import game.Drawable;
import game.Sprite;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

/**
 *
 * @author juancamposbetancourth
 */
public class Proyectil extends enemy implements  Drawable{
    private Image image = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\Proyectil.png");
    public static final int WIDTH = 17;
    public static final int HEIGHT = 32;
    private Drawable drawable;
    
    
    public Proyectil(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
        Thread move = new MoveDown(this,18);
        move.start();
    }
    

   
    @Override
    public void draw(Graphics g) {
        if(image != null){
            g.drawImage(image, getX(), getY(), null);
        }    
    }

    

    @Override
    public void redraw() {
        drawable.redraw();
    } 

    /**
     * @param drawable the drawable to set
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void stop() {
    }
}
