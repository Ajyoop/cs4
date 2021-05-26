/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.Dimension;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JFrame;

/**
 *
 * @author Ellio
 */
public class GameFrame extends JFrame{
    private int width;
    private int height;
    public static int port = 6969;
    private Socket socket;
    private Server Server;
    private game1 game;
    private String playername;
    
   //OM SPELAREN ÄR HOST (starta server) 
    public GameFrame(int width, int height, String playername){
        this.width = width;
        this.height = height;
        this.playername = playername;
        try{
            socket = new Socket("localhost", port);
        }catch(UnknownHostException e){
            
        }catch(IOException ex){
            
        }      
        //Game g = new Game(socket, playername);
        //add(g);
        setSize(new Dimension(1600,900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    
        
}
   
    
   //Om spelaren ska ansluta till en annan server
    public GameFrame(int width, int height, String playername, String ip){
        this.width = width;
        this.height = height;
        this.playername = playername;
        
       try{
            socket = new Socket(ip, port);
        }catch(UnknownHostException e){
            
        }catch(IOException ex){
            
        }
       
        //Game g = new Game(socket, playername);
        //add(g);
        setSize(new Dimension(1600,900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    
        
    }
    
}
