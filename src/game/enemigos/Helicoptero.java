/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import game.Drawable;
import game.Sprite;
import static game.Sprite.loadImage;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Helicoptero extends enemy implements Runnable{
    public static int width=50;
    public static int height=50;
    private LinkedList<Proyectil> bullets;
    Drawable drawable;

    public LinkedList<Proyectil> getBullets() {
        return bullets;
    }

    public void setBullets(LinkedList<Proyectil> bullets) {
        this.bullets = bullets;
    }
   
    public boolean moveLeft=true;
    public Helicoptero() {
        super(700, 35, Helicoptero.width, Helicoptero.height);
        bullets=new LinkedList<>();
    }

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
    public void shoot(){
        Proyectil bullet = new Proyectil(x+47, y);        
        bullets.add(bullet);
    }

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

            // Check if the helicopter has moved off the screen to the left
            

            Thread.sleep(30);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        
    }
    }

    @Override
    public void stop() {
        
    }
    
}
