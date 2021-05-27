/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
    
    private DataInputStream input;
    private DataOutputStream output;
    
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
        while(!Thread.interrupted()){
            try{
            clients.add(new ClientManager(socket.accept(), this));
            System.out.println("Created new Clientmanager");
            }catch(IOException e){

            }
        }
        
    }
    
    
    public void sendPosition(String newPos, ClientManager c){
        if (clients != null) {
            for(ClientManager cm : clients){
            try {
                if (cm != c) {
                    cm.getOutput().writeUTF(newPos);
                }
                } catch (IOException ex) {
                }
            
            }
        }
        
        
    }
    
    
    
}
