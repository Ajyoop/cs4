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
import java.net.InetAddress;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Ellio
 */
public class UsernameFrame extends JFrame implements ActionListener{
    private int width;
    private int height;
    private boolean ishost;
    private JLabel usrlbl;
    private JTextField usrNameField;
    
    private JLabel iplbl;
    private JTextField ipField;
    
    private JButton startBtn;
    
    public UsernameFrame(String title, int width, int height, boolean ishost){
    super(title);
    this.width = width;
    this.height = height;
    this.ishost = ishost;
    usrlbl = new JLabel("Username:");
    usrNameField = new JTextField("");
    usrNameField.setPreferredSize(new Dimension(200,20));
    
    
    startBtn = new JButton("Start");
    startBtn.setPreferredSize(new Dimension(100,50));
    startBtn.addActionListener(this);
    
    GridBagLayout gbl = new GridBagLayout();
    this.setLayout(gbl);
    GridBagConstraints gbc;
    
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;

    gbl.setConstraints(usrlbl, gbc);
    this.add(usrlbl);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;

    gbl.setConstraints(usrNameField, gbc);
    this.add(usrNameField);
    
        if (!ishost) {
            iplbl = new JLabel("Join ip");
            ipField = new JTextField("");
            ipField.setPreferredSize(new Dimension(200,20));
            
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 3;

            gbl.setConstraints(iplbl, gbc);
            this.add(iplbl);

            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 3;

            gbl.setConstraints(ipField, gbc);
            this.add(ipField);

            
            
            
        }
    
    
    
    
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 4;

    gbl.setConstraints(startBtn, gbc);
    this.add(startBtn);
    
    
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    
}
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (ishost) {
            GameFrame g = new GameFrame(width, height, usrNameField.getText());
        }
        else{
            
            GameFrame g = new GameFrame(width, height, usrNameField.getText(), ipField.getText());
        }
        this.dispose();
    }
    
    
    
    
}
