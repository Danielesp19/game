/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.lang.System.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario
 */
public class MovePjThread extends Thread {
    private Sprite p;
    private int direccion;
    private static final int STEEP = 2;
    int cont = 0;
    int cont2=0;

    public MovePjThread(Sprite pm, int direc) {
        this.p = pm;
        this.direccion = direc;
    }

    public void mo (int i){
        this.direccion=i;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);

                // Verifica la dirección y ajusta la posición en consecuencia

                if (cont < 50) {
                    if (direccion == 1 && p.getX()- 50 > 100) {
                        p.setX(p.getX() - STEEP);
                        cont += 1;
                    
                
                    } else if (direccion == 2 && p.getX() + 70 < 670) {
                        p.setX(p.getX() + STEEP);
                        cont += 1;
                    }
                }
            
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}