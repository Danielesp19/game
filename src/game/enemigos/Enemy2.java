/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import game.Sprite;
import static game.Sprite.loadImage;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Usuario
 */
public class Enemy2 extends Sprite implements Runnable{
    public static int width=50;
    public static int height=50;
    
    public boolean moveLeft=true;
    public Enemy2() {
        super(700, 150, Enemy2.width, Enemy2.height);
    }

    @Override
    public void draw(Graphics g) {
        
        Image backgroundImage = loadImage("C:\\Users\\Usuario\\Downloads\\Captura_de_pantalla_2023-11-30_112656-removebg-preview (1).png");
        
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, getX(), getY(), null);
        }
        
    }
    public void shot(){
        
    }

    @Override
    public void run() {
    boolean runn=true;
    while (runn) {
        try {
            // Move to the left until x is 50
            this.x = this.x - 2;

            // Check if the helicopter has moved off the screen to the left
            if (this.x + Enemy2.width <= -150) {
                // Reset the x-coordinate to the right side of the screen
                runn=false;    
            }

            Thread.sleep(7);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
    }
    
}
