/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.lang.System.Logger;

/**
 *
 * @author Usuario
 */
public class MoveThread extends Thread{
    private pj p;
    private int direccion;
    private static final int STEEP = 2;
    int cont=0;
    // holi aa
    public MoveThread(pj pm,int direc) {
        this.p = pm;
        this.direccion=direc;
    }
    
    @Override
    public void run(){
        while (true) {   
            try {
                Thread.sleep(2); // Duerme el hilo por 20 milisegundos (ajusta según sea necesario)

                // Verifica la dirección y ajusta la posición en consecuencia
                if (cont<125){
                    if (direccion == 1) {
                        p.setX(p.getX() - STEEP);
                        cont+=1;
                    } else if (direccion == 2) {
                        p.setX(p.getX() + STEEP);
                        cont+=1;
                    }
                }else{
                    cont=0;
                }
                // Si deseas que el hilo se detenga después de llegar a cierta posición, puedes agregar una condición aquí.
                // Por ejemplo, si deseas detenerte después de 125 píxeles a la derecha:
                // if (direccion == 2 && p.getX() >= 125) {
                //     break;
                // }
                
            } catch (InterruptedException ex) {
                System.out.println(ex);
    }
        }
    }
}
