/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import game.Sprite;
import game.Personaje;
import java.awt.Graphics;

/**
 * Subclase de Sprite.
 * clase abstracta que define si un objeto es un enemigo.
 * @author  Daniel Espitia
 * @version 05122023
 */
public abstract class enemy extends Sprite{
    
    /**
     * @param x posicion en x
     * @param y posicion en y
     * @param width anchor de la franja
     * @param height altura de la fanja
     */
    public enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    /**
     * verifica si la posicion del personaje colisiono con la de un enemigo.
     */
    public boolean choque(Personaje coordenadaPJ) {
        if (this.getX()  < coordenadaPJ.getX() + coordenadaPJ.getWidth() &&
            this.getX()  + this.getWidth() > coordenadaPJ.getX() &&
            this.getY()+70 < coordenadaPJ.getY() + coordenadaPJ.getHeight() &&
            this.getY() + this.getHeight() > coordenadaPJ.getY()) {
            // Se produjo una colisión, marca que no se debe dibujar
            return true;
        }
        return false;
    }
    
    /**
     * Dibuja el helicoptero enemigo.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public abstract void draw(Graphics g);
    
    /**
     * detiene el hilo dle enemigo.
     */
    public abstract void stop();

    

}
