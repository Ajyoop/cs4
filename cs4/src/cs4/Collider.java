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
    private int aimX;
    private int aimY;
    private int height;
    private int width;

    public Collider(double xCoord, double yCoord, int height, int width) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.height = height;
        this.width = width;
    }
    
    
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)xCoord, (int)yCoord, width, height);
        g.drawLine((int)xCoord+width/2, (int)yCoord+width/2, aimX, aimY);
    }
    
    public void move(double x,double y){
        xCoord = x;
        xCoord = y;
        
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public double getxCoord() {
        return xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setAimX(int aimX) {
        this.aimX = aimX;
    }

    public void setAimY(int aimY) {
        this.aimY = aimY;
    }
    
        
    
}
