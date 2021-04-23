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
 * @author elliot.vesterlund
 */
public class Collider {
    private double xCoord;
    private double yCoord;
    private int height;
    private int width;

    public Collider(double xCoord, double yCoord, int height, int width) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.height = height;
        this.width = width;
    }
    
    
    public void move(){
        
    }

    public Collider(double xCoord, double yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.draw3DRect(height, width, (int)xCoord, (int)yCoord, true);
    }
        
    
}
