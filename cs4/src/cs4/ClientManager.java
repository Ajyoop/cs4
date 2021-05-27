/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    private DataInputStream input;
    private DataOutputStream output;
    private Thread t;
    private int playername;
    
    public ClientManager(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.playername = playername;
        
        try {
            output= new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
       while (!t.isInterrupted()) {
            try {
                input = new DataInputStream(socket.getInputStream());
                
                if (input != null) {
                    server.sendPosition(input.readUTF(), this);
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }   
    }

    public Socket getSocket() {
        return socket;
    }


    public DataInputStream getInput() {
        return input;
    }

    public DataOutputStream getOutput() {
        return output;
    }
    
    
    
    
    
    
}
