/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author elliot.vesterlund
 */
public class StartFrame extends JFrame implements ActionListener{
        private int height = 9*100;
        private int width = 16*100;
        private final JButton join;
        private final JButton host;
        private final JButton quit;
        
        
        

    public StartFrame(){
        super("CS4");
        
        join = new JButton("Join Game");
        host = new JButton("Host Game");
        quit = new JButton("Quit");
        
        join.addActionListener(this);
        host.addActionListener(this);
        quit.addActionListener(this);
        
        
        
        Dimension btnDim = new Dimension(100,50);
        join.setPreferredSize(btnDim);
        host.setPreferredSize(btnDim);
        quit.setPreferredSize(btnDim);
        
        
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc;
        
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        gbl.setConstraints(join, gbc);
        this.add(join);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        gbl.setConstraints(host, gbc);
        this.add(host);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        gbl.setConstraints(quit, gbc);
        this.add(quit);
        
        
        
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object choice = e.getSource();
        if (choice == join) {
            UsernameFrame uf = new UsernameFrame("CS4 - Joining", width, height, false);
        }
        else if (choice == host){
            UsernameFrame uf = new UsernameFrame("CS4 - Hosting", width, height, true);
        }
        else if (choice == quit) {
            
        }
        this.dispose();
    }




}
