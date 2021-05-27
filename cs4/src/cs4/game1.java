/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author elliot.vesterlund
 */
public abstract class game1 extends JPanel implements Runnable {
/*
    private ArrayList<Collider> colliders;
    GameKeyListener gkl;
    Thread t;
    Collider c;
    GameMap m;
    private int height;
    private int width;
    

    public game1(String d) {
        this.width = width;
        this.height = height;
        t = new Thread(this);
        gkl = new GameKeyListener();
        System.out.println(width+","+super.getHeight());
        m = new GameMap(50, width, height);
        c = new Player(50,50,50,50);
        addKeyListener(gkl);
        addMouseListener(gkl);
        addMouseMotionListener(gkl);
        colliders = new ArrayList();
        colliders.add(c);
         m = new GameMap(50, super.getWidth(), super.getHeight());
    }
    
    public game1(String usrname, InetAddress a){
        
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                moveKey(gkl.getPressedKeys());
                c.setAimX(gkl.getMouseX());
                c.setAimY(gkl.getMouseY());

                repaint();
                Thread.sleep(16);
            } catch (InterruptedException e) {
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
        m.drawMap(g);
        paintColliders(g);
        m.drawMap(g);

    }

    public void paintColliders(Graphics g) {
        if (colliders != null) {
            for (Collider c : colliders) {
                c.draw(g);
            }
        }
    }

    public void moveKey(HashMap<Integer, Boolean> keys){
                if (keys.get(KeyEvent.VK_W)) {
                    if (isLegalMove(c,0, -5)) {
                         c.setyCoord(c.getyCoord() - 5);
                    }

                }
                if (keys.get(KeyEvent.VK_A)) {
                    if (isLegalMove(c, -5,0)) {
                         c.setxCoord(c.getxCoord()-5);
                    }

                }
                if (keys.get(KeyEvent.VK_S)) {
                    if (isLegalMove(c, 0,+5)) {
                         c.setyCoord(c.getyCoord() + 5);
                    }

                }
                if (keys.get(KeyEvent.VK_D)) {
                    if (isLegalMove(c, +5,0)) {
                         c.setxCoord(c.getxCoord() + 5);
                    }

                }
    }

    public boolean isLegalMove(Collider c, int stepX, int stepY){
        return isInBounds(c, stepX, stepY);
    }
*/
/*
    public boolean isInBounds(Collider c, int stepX, int stepY) {
        int x = (int) c.getxCoord()+stepX;
        int y = (int) c.getyCoord()+stepY;
        if (x > super.getWidth()-c.getWidth()+5 || x < 0|| y > super.getHeight()-c.getHeight() || y < 0 ) {
            return false;
        }

        return true;
    }
*/
}
