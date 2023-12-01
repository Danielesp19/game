/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// Clase principal para la lógica del juego
public class Pista extends Sprite {
    private final pj pj1;             // Nave del jugador
    private Drawable drawable;         // Interfaz para redibujar
    private ArrayList<enemigo> enemy;  // Lista de enemigos
    private BufferedImage buffer;      // Búfer para el doble búfer
    private boolean boostSpeed = false;
    
    
            
    // Constructor para inicializar el juego
    public Pista(int x, int y, int width, int height) {
        super(x, y, width, height);
        pj1 = new pj(width / 2, height - 90,30,140);  // Crear nave del jugador
        enemy = new ArrayList<>();             // Inicializar lista de enemigos
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  // Inicializar búfer
        
    }

    // Método para dibujar la escena del juego
    @Override
    public void draw(Graphics g) {
        // Crear un nuevo contexto gráfico para el búfer
        Graphics bufferGraphics = buffer.getGraphics();

        // Dibujar en el búfer
        bufferGraphics.setColor(Color.GREEN);
        bufferGraphics.fillRect(0, 0, this.width, this.height);

        // Dibujar la pista de carreras
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect( 160, 0, (this.width-320),this.height);
        

        // Dibujar carriles
        bufferGraphics.setColor(Color.WHITE);
        
        bufferGraphics.fillRect(140, 0, 20, this.height);
        bufferGraphics.fillRect(this.width-160, 0, 20, this.height);
        
        

        // Dibujar la nave del jugador en el búfer
        pj1.draw(bufferGraphics);

        // Iterar sobre la lista de enemigos para dibujarlos en el búfer y verificar colisiones
        for (enemigo m : enemy) {
            m.draw(bufferGraphics);  // Dibujar enemigo
            if (m.choque(pj1)){
                
                enemy.remove(m);          // Verificar colisión con la nave del jugador
            }
        }

        // Copiar el contenido del búfer al área visible
        g.drawImage(buffer, 0, 0, null);
        
        // Liberar el contexto gráfico del búfer
        bufferGraphics.dispose();

        // Redibujar la escena (implementación depende de la interfaz Drawable)
        drawable.redraw();
    }

    // Método para establecer la interfaz para redibujar la escena
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    // Método para manejar eventos del teclado
    public void handleKey(int key) {
        // Mover la nave del jugador cuando se presiona izquierda o derecha
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            pj1.direc(key);
            
        }
        
        // Agregar un nuevo enemigo cuando se presiona la tecla "D"
        if (key == KeyEvent.VK_D) {
            int coordenadaX = (int) (Math.random() * 4)+1;
            
            enemigo en = new enemigo(80+(coordenadaX*125), 20, 20, 40, 1);  // Crear nuevo enemigo
            
            enemy.add(en);  // Agregar enemigo a la lista

            // Iniciar el hilo para el nuevo enemigo
            
        }
            
        if (key == KeyEvent.VK_X && !boostSpeed) {
        // Iniciar un hilo para controlar la velocidad mientras "X" está presionada
            boostSpeed = true;  // Activar velocidad rápida al presionar la tecla "X"
            actualizarVelocidadEnemigos();

            Thread boostThread = new Thread(() -> {
            while (boostSpeed) {
                try {
                    Thread.sleep(50);  // Puedes ajustar este valor según la velocidad deseada
                    actualizarVelocidadEnemigos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            });
        

            boostThread.start();
            }
        
        }
        public void handleKeyReleased(int key) {
        if (key == KeyEvent.VK_X) {
            for (enemigo m : enemy) {
                m.setPresx(false);
            }
            boostSpeed = false;  // Desactivar velocidad rápida al soltar la tecla "X"
            actualizarVelocidadEnemigos();
            }
        }
        private void actualizarVelocidadEnemigos() {
        for (enemigo m : enemy) {
            m.setVelocidad(boostSpeed ? 6 : 1);  // Ajusta la velocidad según sea necesario
        }

    }
}

