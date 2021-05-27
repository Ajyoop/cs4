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
import javax.swing.JOptionPane;

/**
 *
 * @author Ellio
 */
public class GameFrame extends JFrame{
    private int width;
    private int height;
    public static int port = 6969;
    private Socket socket;
    private Server server;
    private game1 game;
    private String playername;
    
   //OM SPELAREN ÄR HOST (starta server) 
    public GameFrame(int width, int height, String playername){
        this.width = width;
        this.height = height;
        this.playername = playername;
        //servern startas
        server = new Server(port);
        try{
            System.out.println("SERVER");
            //localhost är hostens lokala ip så man kan bara hårdkoda att ansluta till sig själv
            socket = new Socket("localhost", port);
            //skapar ett game till den som hostar, alltså den som har servern
            Game g = new Game(socket, playername, new Player(100,300, playername));
            add(g);
        }catch(UnknownHostException e){
            
        }catch(IOException ex){
            
        }     
        
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
        
        //Skapar ett spel för den som ansluter sig till servern samt en player
       try{
            System.out.println("JOINER");
            socket = new Socket(ip, port);
            System.out.println("CReated join game");
            Game g = new Game(socket, playername, new Player(400,100, playername));
            add(g);
        }catch(UnknownHostException e){
            JOptionPane.showMessageDialog(null,"Server not found");
            this.dispose();
        }catch(IOException ex){
            
        }
        
        setSize(new Dimension(1600,900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    
        
    }
    
}
