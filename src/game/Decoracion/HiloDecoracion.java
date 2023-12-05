/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.Decoracion;

import game.Sprite;

/**
 *
 * @author Usuario
 */
public class HiloDecoracion extends Thread{
    Sprite decor;

    public HiloDecoracion(Sprite decor) {
        this.decor = decor;
    }
    
    @Override
    public void run()
    {
        while (true) {
            try {
                if(decor.getY()<600){
                    decor.setY(decor.getY() + 2);
                }
                
                else {
                        // Mover hacia abajo más rápido si la tecla "X" está presionada
                    decor.setY(-50);
                }
                Thread.sleep(7);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
