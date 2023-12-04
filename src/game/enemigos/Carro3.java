/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import static game.Sprite.loadImage;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Usuario
 */
public class Carro3 extends enemy{
    private int velocidad;
    private boolean dibujar;
    private boolean presx = false;
    private Thread m;
    public static int width = 30;
    public static int height = 20;

    public Carro3(int x, int y) {
        super(x, y, width, height);
        this.dibujar = true;
        m = new MoveDown(this, 4);
        m.start();
    }

    @Override
    public void draw(Graphics g) {
        if (dibujar) {
            Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\Captura_de_pantalla_2023-12-02_220132-removebg-preview.png");
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, getX(), getY(), null);
            }
        }
    }

    
}
