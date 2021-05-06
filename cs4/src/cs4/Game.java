/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
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
    Point a;
    
    
    public Game() {
        
        t = new Thread(this);
        gkl = new GameKeyListener();
        c = new Collider(50,50,50,50);
        addKeyListener(gkl);
        addMouseListener(gkl);
        addMouseMotionListener(gkl);
        colliders = new ArrayList();
        colliders.add(c);
    }
    
    
    @Override
    public void run() {
        while(!Thread.interrupted()){
            try{
                HashMap<Integer, Boolean> keys = gkl.getPressedKeys();
                
                if (keys.get(KeyEvent.VK_W)) {
                    System.out.println("W");
                    c.setyCoord(c.getyCoord()-5);
                }
                if (keys.get(KeyEvent.VK_A)) {
                    System.out.println("A");
                    c.setxCoord(c.getxCoord()-5);
                }
                if (keys.get(KeyEvent.VK_S)) {
                    System.out.println("S");
                    c.setyCoord(c.getyCoord()+5);
                }
                if (keys.get(KeyEvent.VK_D)) {
                    System.out.println("D");
                    c.setxCoord(c.getxCoord()+5);
                }
                c.setAimX(gkl.getMouseX());
                c.setAimY(gkl.getMouseY());
                
                
                
                
                repaint();
                Thread.sleep(16);
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
