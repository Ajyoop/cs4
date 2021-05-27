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
public abstract class Collider {
    private double xCoord;
    private double yCoord;
    

    public Collider(double xCoord, double yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        
    }
    
    public abstract void draw(Graphics g);

    public double getxCoord() {
        return xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public abstract int getWidth();
    
    public abstract int getHeight();

  
}