/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author elliot.vesterlund
 */
public class Game extends JPanel implements Runnable{
    private ArrayList<Collider> colliders;
    GameKeyListener gkl; 
    Thread t;
    Collider c;
    
    public Game() {
        t = new Thread(this);
        gkl = new GameKeyListener();
        addKeyListener(gkl);
        addMouseListener(gkl);
        colliders = new ArrayList();
        colliders.add(new Collider(50,50,50,50));
    }
    
    
    @Override
    public void run() {
        while(!Thread.interrupted()){
            try{
                
                repaint();
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                break;
            }
                
            
        }
    }

    public Thread getT() {
        return t;
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintColliders(g);
    }
    
    public void paintColliders(Graphics g){
        if(colliders != null){
            for (Collider c: colliders) {
            c.draw(g);
            }
        }
        
        
    }

    
}
