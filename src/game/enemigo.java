/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
import java.awt.Color;
import java.awt.Graphics;

public class enemigo extends Sprite implements Runnable {
    private Drawable drawable;
    private int velocidad; // Nueva variable para controlar la velocidad
    private boolean dibujar; // Nuevo indicador para saber si debe dibujarse
    private boolean presx=false;

    public enemigo(int x, int y, int width, int height, int velocidad) {
        super(x, y, width, height);
        this.velocidad = velocidad;
        this.dibujar = true; // Por defecto, se debe dibujar
    }

    @Override
    public void draw(Graphics g) {
        if (dibujar) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }
    }

    public void choque(pj cordenadaPJ) {
        if (this.getX() < cordenadaPJ.getX() + cordenadaPJ.getWidth() &&
            this.getX() + this.getWidth() > cordenadaPJ.getX() &&
            this.getY() < cordenadaPJ.getY() + cordenadaPJ.getHeight() &&
            this.getY() + this.getHeight() > cordenadaPJ.getY()) {
            // Se produjo una colisión, marca que no se debe dibujar
            dibujar = false;
        }
    }

    public void setPresx(boolean presx) {
        this.presx = presx;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                if (!presx) {
                    synchronized (this) {
                        // Mover hacia abajo con velocidad normal
                        this.setY(this.getY() + velocidad);
                    }
                    Thread.sleep(10);
                } else {
                    // Mover hacia abajo más rápido si la tecla "X" está presionada
                    this.setY(this.getY() + velocidad);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
    

    
   

