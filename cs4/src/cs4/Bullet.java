/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs4;

import java.awt.Graphics;

/**
 *
 * @author Ellio
 */
public class Bullet extends Collider{
    private double angle;
    private int vel;
    
    
public Bullet(double xCoord, double yCoord) {
        super(xCoord, yCoord);
        
        
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    







}
