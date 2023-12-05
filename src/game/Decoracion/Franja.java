/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.Decoracion;

import game.Decoracion.HiloDecoracion;
import game.Sprite;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Subclase de Sprite.
 * simula una franja en una carretera.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Franja extends Sprite{
    /**
     * Hilo que controla el movimiento del carro.
     */
    Thread m;
    
    /**
     * 
     * @param x posicion en x
     * @param y posicion en y
     * @param width anchor de la franja
     * @param height altura de la fanja
     */
    public Franja(int x, int y, int width, int height) {
        super(x, y, width, height);
        m=new HiloDecoracion(this);
        m.start();
        
    }
    
    /**
     * Dibuja la franja de decoracion.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public void draw(Graphics g) {
        Color blancoPocoAmarillo = new Color(250, 250, 214);
        g.setColor(blancoPocoAmarillo);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
}
