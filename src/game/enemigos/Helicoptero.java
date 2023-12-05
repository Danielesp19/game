/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import visual.Drawable;
import game.Sprite;
import static game.Sprite.loadImage;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

/**
 * Subclase de enemy implementa el metodo run.
 * simula un enemigo de tipo helicoptero el cual puede atacar.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Helicoptero extends enemy implements Runnable{
    /**
     * Lista de proyectiles del helicoptero.
     */
    private LinkedList<Proyectil> bullets;
    /**
     * instancia del panel drawable.
     */
    Drawable drawable;
    /**
     * Constructor de la clase enemiga de tipo helicoptero
     */
    public Helicoptero() {
        super(700, 35, 50,50);
        bullets=new LinkedList<>();
    }
    
    /**
     * Dibuja el helicoptero enemigo.
     * @param g Objeto Graphics para dibujar el carro.
     */
    @Override
    public void draw(Graphics g) {
        Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\helicoptero.png");
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, getX(), getY(), null);
        }
        for (Proyectil bullet : bullets) {
            bullet.draw(g);
        } 
    }
    
    /**
     * genera un proyectil desde el helicoptero.
     */
    public void shoot(){
        Proyectil bullet = new Proyectil(x+47, y);        
        bullets.add(bullet);
    }
    /**
     * Detiene el movimiento del helicoptero.
     */
    @Override
    public void stop() {
        
    }
    
    /**
     * Movimiento y comprotamiento del helicoptero.
     */
    @Override
    public void run() {
    boolean runn=true;
    while (runn) {
        try {
            // Move to the left until x is 50
            this.x = this.x - 2;
            int cord1 = (int) (Math.random() * 400) + 180;
            int cord2 = (int) (Math.random() * 400) + 180;
            int cord3 = (int) (Math.random() * 400) + 180;
            
            if(this.x==cord1||this.x==cord2||this.x==cord3)
                shoot();
            Thread.sleep(30);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        
    }
    }
    public LinkedList<Proyectil> getBullets() {
        return bullets;
    }
    public void setBullets(LinkedList<Proyectil> bullets) {
        this.bullets = bullets;
    }
    
    
}
