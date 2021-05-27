/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author elliot.vesterlund
 */
public class Player extends Collider{
    private ArrayList<Bullet> bullets = new ArrayList();
    private String playername;
    private static int width = 100;
    private static int height = 100;
    
    public Player(double xCoord, double yCoord, String username) {
        super(xCoord, yCoord);
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)this.getxCoord(), (int)this.getyCoord(), width, height);
        
    }

    //Räknar ut vinkeln mellan musens koordinater och punkten där bulleten avfyras.
    public double getAngle(double mousex, double mousey) {
    double angle = (double) Math.toDegrees(Math.atan2(this.getyCoord()-mousey, this.getxCoord()-mousex));
        System.out.println(angle);
    

    return angle;
}
    
    
    //Skapar en ny bullet med koordinaterna från playern samt en angle till musesn koordinater
    public Bullet shoot(double mousex, double mousey){
        Bullet b = new Bullet(this.getxCoord(), this.getyCoord(), getAngle(mousex, mousey));
        
        
        return b;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPlayername() {
        return playername;
    }

    /*
    @Override
    public void setxCoord(double cord) {
        super.setxCoord(cord);
    }
    
    @Override
    public void setyCoord(double cord) {
        super.setyCoord(cord);
    } 
    
    @Override
    public double getxCoord() {
        return super.getyCoord();
    } 
    
    @Override
    public double getyCoord() {
        return super.getyCoord();
    } 
    */
}
