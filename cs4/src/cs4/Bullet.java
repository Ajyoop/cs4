/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs4;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ellio
 */
public class Bullet extends Collider{
    private double angle;
    private  static int vel = 10;
    private static int width = 4;
    private static int height = 4;
    
    
public Bullet(double xCoord, double yCoord, double angle) {
        super(xCoord, yCoord);
        this.angle = angle;
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int)this.getxCoord(), (int)this.getyCoord(), width, height);
    }
    
    public double getXVel(){
        return Math.cos(angle)*vel;
    }
    public double getYVel(){
        return Math.sin(angle)*vel;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }






}
