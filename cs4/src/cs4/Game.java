/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author Ellio
 */
public class Game extends JPanel implements Runnable{
    private int width;
    private int height;
    
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String playername;
    
    private GameKeyListener gkl;
    
    private Thread t;
    
    private GameMap m;
    
    private ArrayList<Player> players = new ArrayList();
    private Player player;
    
    
    
    
    Game(Socket socket, String playername) {
        this.socket = socket;
        this.playername = playername;
        this.t = new Thread(this);
        
        this.gkl = new GameKeyListener();
        addKeyListener(gkl);
        addMouseListener(gkl);
        addMouseMotionListener(gkl); 
        
        t.start();
    }
    
   
    @Override
    public void run() {
        moveKey(gkl.getPressedKeys());
        sendPosition(player);
        
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        m.drawMap(g);
        
        for(Player p : players){
            
        }
        
    
        
        
        
    }
    
    
    public void moveKey(HashMap<Integer, Boolean> keys){
                if (keys.get(KeyEvent.VK_W)) {
                    if (isLegalMove(player,0, -5)) {
                         player.setyCoord(player.getyCoord() - 5);
                    }

                }
                if (keys.get(KeyEvent.VK_A)) {
                    if (isLegalMove(player, -5,0)) {
                         player.setxCoord(player.getxCoord()-5);
                    }

                }
                if (keys.get(KeyEvent.VK_S)) {
                    if (isLegalMove(player, 0,+5)) {
                         player.setyCoord(player.getyCoord() + 5);
                    }

                }
                if (keys.get(KeyEvent.VK_D)) {
                    if (isLegalMove(player, +5,0)) {
                         player.setxCoord(player.getxCoord() + 5);
                    }

                }
    }
    
    public boolean isLegalMove(Player player, int stepX, int stepY){
        return isInBounds(player, stepX, stepY);
    }


    public boolean isInBounds(Collider c, int stepX, int stepY) {
        int x = (int) c.getxCoord()+stepX;
        int y = (int) c.getyCoord()+stepY;
        if (x > super.getWidth()-c.getWidth()+5 || x < 0|| y > super.getHeight()-c.getHeight() || y < 0 ) {
            return false;
        }

        return true;
    }
    
    
    
    
    
    
    
    
}
