/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import java.awt.Color;
import java.awt.Graphics;

public class Arbusto extends Sprite {
    public static int width = 60;
    public static int height = 20;
    Thread m;

    public Arbusto(int x, int y) {
        super(x, y, width, height);
        m=new MoveDecor(this);
        m.start();
    }

    @Override
    public void draw(Graphics g) {
        Color blancoPocoAmarillo = new Color(0, 128, 0);
        g.setColor(blancoPocoAmarillo);
        
        // Dibuja tres cuadrados verdes juntos
        int squareSize = width / 3;
        
        g.fillRect(getX(), getY(), squareSize, height);
        g.fillRect(getX() + squareSize, getY()-10, squareSize, height+10);
        g.fillRect(getX() + 2 * squareSize, getY(), squareSize, height);
    }
}
