/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.HashMap;

/**
 *
 * @author elliot.vesterlund
 */
public class GameKeyListener implements KeyListener, MouseListener{
    HashMap<Integer, Boolean> pressedKeys = new HashMap<Integer, Boolean>();
    

    public GameKeyListener() {
        pressedKeys.put(KeyEvent.VK_W , false);
        pressedKeys.put(KeyEvent.VK_A, false);
        pressedKeys.put(KeyEvent.VK_S, false);
        pressedKeys.put(KeyEvent.VK_D, false);
        
        
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_W:
                
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("sdasd");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}

