/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.Decoracion;
import game.Decoracion.HiloDecoracion;
import game.Sprite;
import static game.Sprite.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Subclase de Sprite.
 * simula una casa.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Casa extends Sprite{
    
    /**
     * Hilo que controla el movimiento del carro.
     */
    Thread m;
    
    /**
     * constructor de decoracion de tipo casa
     * @param x posicion en el eje x.
     * @param y posicion en el eje y.
     */
    public Casa(int x, int y) {
        super(x, y, 60, 20);
        m=new HiloDecoracion(this);
        m.start();
    }

    
    /**
     * Dibuja una casa de decoracion.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public void draw(Graphics g) {
       // Configura el color
       Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\183437938-house-facade-pixelated-style-icon__1_-removebg-preview (1).png");
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, getX(), getY(), null);
            }
        
    }
    
}

