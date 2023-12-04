/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.enemigos;

import game.Sprite;
import game.pj;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public abstract class enemy extends Sprite{
    private int velocidad;
    private boolean dibujar;
    private boolean presx = false;
    private Thread m;
    
    
    public enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public boolean choque(pj coordenadaPJ) {
        if (this.getX()  < coordenadaPJ.getX() + coordenadaPJ.getWidth() &&
            this.getX()  + this.getWidth() > coordenadaPJ.getX() &&
            this.getY()+70 < coordenadaPJ.getY() + coordenadaPJ.getHeight() &&
            this.getY() + this.getHeight() > coordenadaPJ.getY()) {
            // Se produjo una colisión, marca que no se debe dibujar
            return true;
        }
        return false;
    }

    @Override
    public abstract void draw(Graphics g);
    

    public void setPresx(boolean presx) {
        this.presx = presx;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
