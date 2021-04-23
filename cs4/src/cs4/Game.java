/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author elliot.vesterlund
 */
public class Game extends JPanel{
    private ArrayList<Collider> Colliders;
    Timer tm;
    
    
    
    public Game() {
        
    }
    
    
    public void paintComponent (Graphics g){
        super.paintComponents(g);
        
    
}
    
    public void paintColliders(Graphics g){
        for (Collider c: Colliders) {
            c.get
        }
    }
    
}
