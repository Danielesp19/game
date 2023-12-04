/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import Text.ReadFile;
import static Text.ReadFile.readAndParseFile;
import game.enemigos.Carro1;
import game.enemigos.Carro2;
import game.enemigos.Carro3;
import game.enemigos.Carro4;
import game.enemigos.Enemy2;
import game.enemigos.enemy;
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
    private ArrayList<enemy> enemy;  // Lista de enemigos
    private BufferedImage buffer;      // Búfer para el doble búfer
    private boolean boostSpeed = false;
    
    private ArrayList<Sprite> decoraciones; 
            
    // Constructor para inicializar el juego
    public Pista(int x, int y, int width, int height) {
        super(x, y, width, height);
        pj1 = new pj(width / 2, height - 90,30,140);  // Crear nave del jugador
        enemy = new ArrayList<>();             // Inicializar lista de enemigos
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  // Inicializar búfer
        decoraciones=new ArrayList<>();
        
        for(int i=1;i<=3;i++){
            Franja f=new Franja(155+(130*i), 120, 15, 50);
            decoraciones.add(f);
            Franja f2=new Franja(155+(130*i), 240, 15, 50);
            decoraciones.add(f2);
            Franja f3=new Franja(155+(130*i), 360, 15, 50);
            decoraciones.add(f3);
            Franja f4=new Franja(155+(130*i), 480, 15, 50);
            decoraciones.add(f4);
            Franja f5=new Franja(155+(130*i), 600, 15, 50);
            decoraciones.add(f5);
        }
        
        
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
        

        // Iterar sobre la lista de enemigos para dibujarlos en el búfer y verificar colisiones
        for (enemy m : enemy) {
            m.draw(bufferGraphics);  // Dibujar enemigo
            if (m.choque(pj1)){
                
                enemy.remove(m);          // Verificar colisión con la nave del jugador
            }
        }
        
        for (Sprite m:decoraciones){
            m.draw(bufferGraphics);
        }
        
        pj1.draw(bufferGraphics);
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
    public void addEnemy() {
    ReadFile reader = new ReadFile();
    String filePath = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Game\\src\\Text\\Enemigos.txt";

    // Llamamos al método para leer y parsear el archivo
    int[][] result = readAndParseFile(filePath);

    // Imprimimos la matriz resultante
    if (result != null) {
        for (int i = 0; i < result.length; i++) {
            int[] row = result[i];
            for (int j = 0; j < row.length; j++) {
                enemy en = createEnemy(row[j], j);
                if (en != null) {
                    enemy.add(en);
                }
            }
        }
    }
}

private enemy createEnemy(int type, int index) {
    int x = 80 + ((1 + index) * 125);

    switch (type) {
        case 1:
            return new Carro1(x, 10);
        case 2:
            return new Carro2(x, 10);
        case 3:
            return new Carro3(x, 10);
        case 4:
            return new Carro4(x, 10);
        default:
            return null;
    }
}

    // Método para manejar eventos del teclado
    public void handleKey(int key) {
        // Mover la nave del jugador cuando se presiona izquierda o derecha
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            pj1.direc(key);
            
        }
        // Agregar un nuevo enemigo cuando se presiona la tecla "D"
        if (key == KeyEvent.VK_D) {
            addEnemy();
        }
        
        if (key == KeyEvent.VK_F) {
            Enemy2 helicoptero=new Enemy2();
            Thread d = new Thread(helicoptero);
            d.start();
            decoraciones.add(helicoptero);
            
            
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
            for (enemy m : enemy) {
                m.setPresx(false);
            }
            boostSpeed = false;  // Desactivar velocidad rápida al soltar la tecla "X"
            actualizarVelocidadEnemigos();
            }
        }
        private void actualizarVelocidadEnemigos() {
        for (enemy m : enemy) {
            m.setVelocidad(boostSpeed ? 6 : 1);  // Ajusta la velocidad según sea necesario
        }
        
        

    }
}

