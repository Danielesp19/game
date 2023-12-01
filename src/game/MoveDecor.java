/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Usuario
 */
public class MoveDecor implements Runnable{
    Sprite objec;
    boolean presx;
    int velocidad;
    
    
    public MoveDecor(Sprite Objec) {
        this.objec = Objec;
    }
    
    public void setPresx(boolean presx) {
        this.presx = presx;
    }
    
    @Override
    public void run() {
        for (;;) {
            try {
                
                if (!presx) {
                    synchronized (this) {
                        
                        // Mover hacia abajo con velocidad normal
                        objec.setY(objec.getY() + velocidad);
                    }
                    Thread.sleep(10);
                } else {
                    // Mover hacia abajo más rápido si la tecla "X" está presionada
                    objec.setY(objec.getY() + velocidad);
                    Thread.sleep(4);
                }
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }
    
}
