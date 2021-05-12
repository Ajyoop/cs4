/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author elliot.vesterlund
 */
public class Gameframe extends JFrame{
	public int height = 9*50;
        public int width = 16*50;
        Game g;
        
    public Gameframe(){
        g = new Game();
        g.setFocusable(true);
        g.requestFocusInWindow();
        add(g);
        setSize(width, height);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public Game getGame() {
        return g;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Game getG() {
        return g;
    }
    
    
    
    
}
