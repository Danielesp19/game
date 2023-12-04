/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Usuario
 */
public class MoveDecor extends Thread{
    Sprite decor;

    public MoveDecor(Sprite decor) {
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
                    decor.setY(0);
                }
                Thread.sleep(7);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
