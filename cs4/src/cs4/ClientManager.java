/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ellio
 */
public class ClientManager implements Runnable{
    private Socket socket;
    private Server server;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Thread t;
    private int playernum;
    
    public ClientManager(Socket socket, Server server, int playernum) {
        
        this.server = server;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (!t.isInterrupted()) {
            
            if (input != null) {
                
            
                try {
                    input = new ObjectInputStream(socket.getInputStream());
                    if (input.readObject() instanceof String) {



                    }else if(input.readObject() instanceof Player){



                    }else if(input.readObject() instanceof Bullet){

                    }

                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }   
    }
    
    
}
