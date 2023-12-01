/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import static game.Sprite.loadImage;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class enemigo extends Sprite  {
    private Drawable drawable;
    private int velocidad; // Nueva variable para controlar la velocidad
    private boolean dibujar; // Nuevo indicador para saber si debe dibujarse
    private boolean presx=false;
    public Thread m;

    public enemigo(int x, int y, int width, int height, int velocidad) {
        super(x, y, width, height);
        this.velocidad = velocidad;
        this.dibujar = true; // Por defecto, se debe dibujar
        m=new MoveDown(this, velocidad);
        m.start();
        
        
    }

    @Override
    public void draw(Graphics g) {
        if (dibujar) {
            Image backgroundImage = loadImage("C:\\Users\\Usuario\\Downloads\\Captura_de_pantalla_2023-11-30_112853-removebg-preview.png");
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, getX(), getY(), null);
        }
        }
    }

    public boolean choque(pj cordenadaPJ) {
        if (this.getX()+-10 < cordenadaPJ.getX() + cordenadaPJ.getWidth() &&
            this.getX()+10 + this.getWidth() > cordenadaPJ.getX() &&
            this.getY() < cordenadaPJ.getY() + cordenadaPJ.getHeight() &&
            this.getY() + this.getHeight() > cordenadaPJ.getY()) {
            // Se produjo una colisión, marca que no se debe dibujar
            return true;
        }
        return false;
    }

    public void setPresx(boolean presx) {
        this.presx = presx;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        
    }
    
    
    
}
    

    
   

