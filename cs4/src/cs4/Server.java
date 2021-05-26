/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Ellio
 */
public class Server implements Runnable{
    private ServerSocket socket;
    private ArrayList<ClientManager> clients;
    private Thread t;
    
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    public Server(int port){
        clients = new ArrayList();
        try{
            socket = new ServerSocket(port);
        }catch(IOException e){
            
        }
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        try{
            clients.add(new ClientManager(socket.accept(), clients.size()));
        }catch(IOException e){
            
        }
    }
    
}
