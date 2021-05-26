/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

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

    
    public Player(double xCoord, double yCoord, String username) {
        super(xCoord, yCoord);
        
    }

    @Override
    public void draw(Graphics g) {
        
    }

    
    public void shoot(){
        
    }

       
}
