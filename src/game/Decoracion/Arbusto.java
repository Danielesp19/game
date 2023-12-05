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
 * simula un arbusto.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Arbusto extends Sprite {
    /**
     * Hilo que controla el movimiento del carro.
     */
    Thread m;
    
    /**
     * constructor de la clase arbusto
     * @param x posicion en el eje x.
     * @param y posicion en el eje y.
     */
    public Arbusto(int x, int y) {
        super(x, y, 60, 20);
        m=new HiloDecoracion(this);
        m.start();
    }
    
    /**
     * Dibuja un arbusto de decoracion.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public void draw(Graphics g) {
        Color blancoPocoAmarillo = new Color(0, 128, 0);
        g.setColor(blancoPocoAmarillo);
        
        // Dibuja tres cuadrados verdes juntos
        int squareSize = width / 3;
        
        g.fillRect(getX(), getY(), squareSize, height);
        g.fillRect(getX() + squareSize, getY()-10, squareSize, height+10);
        g.fillRect(getX() + 2 * squareSize, getY(), squareSize, height);
    }
}
