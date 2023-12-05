/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import static game.Sprite.loadImage;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Subclase de Sprite.
 * simula un auto enemigo que obstaculiza el paso.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Carro4 extends enemy{
    /**
     * Bandera que permite dibujar el carro.
     */
    private boolean dibujar;
    /**
     * Hilo que controla el movimiento del carro.
     */
    private Thread m;
    
    /**
     * constructor de la clase carro tipo 4
     * @param x posicion en el eje x.
     * @param y posicion en el eje y.
     */
    public Carro4(int x, int y) {
        super(x, y, 26,75);
        this.dibujar = true;
        m = new MoveDown(this, 15);
        m.start();
    }
    
    /**
     * Dibuja el carro enemigo.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public void draw(Graphics g) {
        if (dibujar) {
            Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\Captura_de_pantalla_2023-12-02_220039-removebg-preview (1).png");
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, getX(), getY(), null);
            }
        }
        
    }
    
    /**
     * Detiene el movimiento del carro.
     */
    @Override
    public void stop() {
    m.stop();    
    }

    
}
