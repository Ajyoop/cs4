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
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import java.util.HashMap;

/**
 *
 * @author elliot.vesterlund
 */
public class GameKeyListener implements KeyListener, MouseListener, MouseMotionListener{
    HashMap<Integer, Boolean> pressedKeys = new HashMap<Integer, Boolean>();
    private int mouseX;
    private int mouseY;
    //Skapar nycklar för de knappar som man ska kunna trycka på
    public GameKeyListener() {
        pressedKeys.put(KeyEvent.VK_W , false);
        pressedKeys.put(KeyEvent.VK_A, false);
        pressedKeys.put(KeyEvent.VK_S, false);
        pressedKeys.put(KeyEvent.VK_D, false);
        pressedKeys.put(KeyEvent.VK_SPACE, false);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    
    
    //Om knappen är nedtryckt så sätts den till true i hashmappen
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_W:
                pressedKeys.put(KeyEvent.VK_W, true);
                break;
            case KeyEvent.VK_A:
                pressedKeys.put(KeyEvent.VK_A, true);
                break;
            case KeyEvent.VK_S:
                pressedKeys.put(KeyEvent.VK_S, true);
                break;
            case KeyEvent.VK_D:
                pressedKeys.put(KeyEvent.VK_D, true);
                break;
            case KeyEvent.VK_SPACE:
                pressedKeys.put(KeyEvent.VK_SPACE , true);
                break;
        }
    }

    
    //om Knappen släpps så sättes den återigen till false
    @Override
    public void keyReleased(KeyEvent e) {
       int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_W:
                pressedKeys.put(KeyEvent.VK_W , false);
                break;
            case KeyEvent.VK_A:
                pressedKeys.put(KeyEvent.VK_A , false);
                break;
            case KeyEvent.VK_S:
                pressedKeys.put(KeyEvent.VK_S , false);
                break;
            case KeyEvent.VK_D:
                pressedKeys.put(KeyEvent.VK_D , false);
                break;
            case KeyEvent.VK_SPACE:
                pressedKeys.put(KeyEvent.VK_SPACE , false);
                break;
                
        }
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


    public HashMap<Integer, Boolean> getPressedKeys() {
        return pressedKeys;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }



}
