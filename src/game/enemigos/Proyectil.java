/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemigos;

import visual.Drawable;
import java.awt.Graphics;
import java.awt.Image;


/**
 * Subclase de enemy.
 * simula un proyectil lanzado por la clase helicoptero.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Proyectil extends enemy implements  Drawable{
    /**
     * Imagen del proyectil.
     */
    private Image image = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\Proyectil.png");
    /**
     * instancia del panel drawable.
     */
    private Drawable drawable;
    
    /**
     * 
     * @param x posicion en el eje x
     * @param y posicion en el eje y
     */
    public Proyectil(int x, int y) {
        super(x, y, 17, 32);
        Thread move = new MoveDown(this,18);
        move.start();
    }
    

   /**
     * Dibuja el carro enemigo.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public void draw(Graphics g) {
        if(image != null){
            g.drawImage(image, getX(), getY(), null);
        }    
    }

    
    /**
     * Redibuja el proyectil.
     */
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
    
    /**
     * Detiene el movimiento del helicoptero.
     */
    @Override
    public void stop() {
    }
}
