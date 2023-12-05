/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import visual.Drawable;
import static game.Sprite.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 * Subclase de Sprite.
 * simula el carro principal el cual se va a manejar.
 * @author  Daniel Espitia
 * @version 05122023
 */
public class Personaje extends Sprite implements Drawable{
    // Constantes que definen las dimensiones y el paso del personaje
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int STEP = 20;
    
    // Variable que almacena la cantidad de vidas del personaje.
    public int vida=3;
    
    // Referencia de Drawable para el dibujo del personaje.
    private Drawable drawable;
    
    // Hilo de ejecución para manejar el movimiento del personaje.
    public Thread m;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    /**
     * constructor de personaje
     * @param x condenada en x.
     * @param y coordenada en y.
     * @param WIDTH dimencion de ancho.
     * @param HEIGHT  dimencion de alto.
     */
    public Personaje(int x, int y,int WIDTH,int HEIGHT) {
        super(x, y, WIDTH, HEIGHT);
        
        // Inicializa el hilo de ejecución para el personaje.
        m = new HiloPersonaje(this,0);
    }
    
    /**
     * Método que se encarga de dibujar el personaje.
     * @param g Objeto Graphics utilizado para dibujar.
     */
    @Override
    public void draw(Graphics g) {
        Image backgroundImage = loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\Firefly_dame_la_imagen_de_un_carro_tipo_juego_visto_desde_arriba_que_mire_hacia_atras_simple_17639-removebg-preview (1).png");
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, getX(), getY(), null);
        }
        
        if (this.vida==3) {
            Image vidas= loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\3vidas_1.png");
            g.drawImage(vidas, 10, 30, null);
        }
        if (this.vida==2) {
            Image vidas= loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\2vidas.png");
            g.drawImage(vidas, 10, 30, null);
        }
        if (this.vida==1) {
            Image vidas= loadImage("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\1vida.png");
            g.drawImage(vidas, 10, 30, null);
        }
        
    }
    
    
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        
    }
   
    /**
     * Método de la interfaz Drawable que redibuja el personaje.
     */
    @Override
    public void redraw() {
            drawable.redraw();
    }
    
    /**
     * Cambia la dirección de movimiento del personaje según la tecla presionada.
     *
     * @param key Código de la tecla presionada.
     */
    public void direc(int key) {
        if(key == KeyEvent.VK_LEFT){
            m.stop();
            m = new HiloPersonaje(this,1);
            m.start();
        }
        if(key== KeyEvent.VK_RIGHT){
            m.stop();
            m = new HiloPersonaje(this,2);
            m.start();
        }
        }   
    } 
    
    

