/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author elliot.vesterlund
 */
public class Game extends JPanel implements Runnable{
    private ArrayList<Collider> colliders;
    Timer tm;
    Thread t;
    Collider cs;
    
    public Game() {
        t = new Thread(this);
        cs = new Collider(50,50,50,50);
        //colliders.add(c);
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
       
        g.drawRect(100, 100, 100, 100);
        paintColliders(g);
    }
    
    public void paintColliders(Graphics g){
        cs.draw(g);
        System.out.println("paint colle");
    }

    
}
