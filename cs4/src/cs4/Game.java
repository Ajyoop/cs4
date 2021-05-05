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
public class Game extends JPanel implements Runnable{
    private ArrayList<Collider> colliders;
    Timer tm;
    
    
    
    public Game() {
        Collider c = new Collider(50,50,50,50);
        colliders.add(0,c);
        repaint();
        System.out.println("CCCCCCCC");
    }
    
    
    @Override
    public void run() {
        
    }
    
    
    public void paintComponent(Graphics g){
        System.out.println("cooks");
        super.paintComponent(g);
        paintColliders(g);
    
}
    
    public void paintColliders(Graphics g){
        for (Collider c: colliders) {
            c.paint(g);
        }
    }

    
}
