/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Ellio
 */
public class Game extends JPanel implements Runnable {

    private int width = 1600;
    private int height = 900;

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private String playername;

    private GameKeyListener gkl;

    private Thread t;

    private GameMap m;

    private int nr;
    private Player player;
    private Player otherplayer;

    private ArrayList<Bullet> bullets;
    int n = 0;
    Game(Socket socket, String playername, Player p) {
        this.player = p;
        this.nr = nr;
        this.socket = socket;
        this.playername = playername;
        otherplayer = new Player(400,100,"2");
        bullets = new ArrayList();
        System.out.println("Gamename: " + playername);
        this.t = new Thread(this);

        //kopplar min GameKeyListener
        gkl = new GameKeyListener();
        addKeyListener(gkl);
        addMouseListener(gkl);
        addMouseMotionListener(gkl);
        
        
        System.out.println("START thread");
        t.start();
        setFocusable(true);
        requestFocus();
        
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                //flytta bullets
                moveBullets();
                //kola om player ska flyttas
                moveKey(gkl.getPressedKeys(), player);
               // System.out.println(player.getxCoord()+" "+player.getyCoord());
                //System.out.println(gkl.getMouseX()+" "+gkl.getMouseY());
                
                //Skicka playerns positions till den andra spelaren
                sendPlayer();
                //System.out.println("sendplayer");
                
                input = new DataInputStream(socket.getInputStream());
                //kolla om det finns en input
                if (input != null) {
                    String inputstring = input.readUTF();
                    //System.out.println(inputstring);
                    //HAr ska informationen om nya bullets skickas för att skrivas ut till den andra spelaren
                    //Problem eftersom detr är så många nullets samtidigt.
                    if (inputstring.contains("bullet")) {
                        String msg = inputstring;
                        msg = msg.substring(5);
                        
                        
                        msg = msg.substring(msg.indexOf(":") + 1);

                        double x = Double.parseDouble(msg.substring(0, msg.indexOf(":")));
                        msg = msg.substring(msg.indexOf(":") + 1);

                        double y = Double.parseDouble(msg.substring(0, msg.indexOf(":")));
                        msg = msg.substring(msg.indexOf(":") + 1);
                        double angle = Double.parseDouble(msg);

                        
                        System.out.println(x+" ,"+y+","+angle);
                        bullets.add(new Bullet(x,y,angle));
                        

                    } else{
                        //Läser ut koordinaterna ur strängen från den andra spelaren och skapar en ny Player som sedan ritas upp
                        String msg = inputstring;
                        
                        String username = msg.substring(0, msg.indexOf(":"));
                        msg = msg.substring(msg.indexOf(":")+1);
                        
                        double x = Double.parseDouble(msg.substring(0, msg.indexOf(":")));
                        msg = msg.substring(msg.indexOf(":")+1);

                        double y = Double.parseDouble(msg.substring(0));
                       
                        otherplayer = new Player(x, y, username);
                    }
                }
                //System.out.println("loop");
                Thread.sleep(17);
                repaint();
            } catch (IOException ex) {

            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    
    //Paintcomponent
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //m.drawMap(g);

        
        player.draw(g);
        otherplayer.draw(g);
        if (bullets != null) {
            for(Bullet b : bullets){
            b.draw(g);
        }
        }
        
    }

    /**
     *Skickar koordinaterna för spelaren till servern som sedan skickar de vidare till andra spelaren
     */
    public void sendPlayer() {
        if (player != null) {

            try {
                output = new DataOutputStream(socket.getOutputStream());

                output.writeUTF(player.getPlayername() + ":" + player.getxCoord() + ":" + player.getyCoord());
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     *
     * @param keys hashmap som uppdateras med vilka knappar som är nedtryckta
     * @param c Spelaren som ska flytta sig
     */
    public void moveKey(HashMap<Integer, Boolean> keys, Player c){
                if (keys.get(KeyEvent.VK_W)) {
                    if (isLegalMove(c,0, -5)) {
                         c.setyCoord(c.getyCoord() - 10);
                    }

                }
                if (keys.get(KeyEvent.VK_A)) {
                    if (isLegalMove(c, -5,0)) {
                         c.setxCoord(c.getxCoord()-10);
                    }

                }
                if (keys.get(KeyEvent.VK_S)) {
                    if (isLegalMove(c, 0,5)) {
                         c.setyCoord(c.getyCoord() + 10);
                    }

                }
                if (keys.get(KeyEvent.VK_D)) {
                    if (isLegalMove(c, 5,0)) {
                         c.setxCoord(c.getxCoord() + 10);
                    }

                }
                if (keys.get(KeyEvent.VK_SPACE)) {
                    bullets.add(player.shoot(gkl.getMouseX(), gkl.getMouseY()));
                    
                
                }

                
                
    }

    /**
     *lik Isinbound men ska innehålla mer kod för kollision mellan players
     * Den kollsionen ska göras med Polygon.Contains
     * @param c
     * @param stepX
     * @param stepY
     * @return
     */
    public boolean isLegalMove(Collider c, int stepX, int stepY) {
        return isInBounds(c, stepX, stepY);
    }

    /**
     * Kollar om en collider är innanför spelbanan
     * @param c Collider, Bullet eller player
     * @param stepX, Steg att ta i x-led
     * @param stepY, steg att ta i y-led
     * @return
     */
    public boolean isInBounds(Collider c, int stepX, int stepY) {
        int x = (int) c.getxCoord() + stepX;
        int y = (int) c.getyCoord() + stepY;
        if (x > width - c.getWidth() + 5 || x < 0 || y > height - c.getHeight() || y < 0) {
            return false;
        }
        return true;
    }
    
    /**
     *Flyttar alla Bullets i ArrayListen av bullets
     */
    public void moveBullets(){
        
        if (bullets != null) {
            for(Bullet b : bullets){
                if (isInBounds(b,(int)b.getXVel(),(int)b.getYVel())) {
                    b.setxCoord(b.getxCoord()+b.getXVel());
                    b.setyCoord(b.getyCoord()+b.getYVel());
                }else{
                    //Ta bort de bullets som är utanför skärmen
                   //bullets.remove(b);
                   
                }
                
        }
        }
        
        
    }

    
    
    

}
