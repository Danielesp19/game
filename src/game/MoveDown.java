/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Usuario
 */
public class MoveDown extends Thread{
    public Sprite objec;
    boolean presx;
    int velocidad;
    
    
    public MoveDown(Sprite Ob, int vel) {
        this.objec = Ob;
        this.velocidad=vel;
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
                    Thread.sleep(velocidad);
                } else {
                    // Mover hacia abajo más rápido si la tecla "X" está presionada
                    objec.setY(objec.getY() + velocidad);
                    Thread.sleep(velocidad*2);
                }
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }
    
}
