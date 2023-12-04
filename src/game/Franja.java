/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class Franja extends Sprite{
    Thread m;

    public Franja(int x, int y, int width, int height) {
        super(x, y, width, height);
        m=new MoveDecor(this);
        m.start();
        
    }

    @Override
    public void draw(Graphics g) {
        Color blancoPocoAmarillo = new Color(250, 250, 214);
        g.setColor(blancoPocoAmarillo);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
}
