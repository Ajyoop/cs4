/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 *
 * @author elliot.vesterlund
 */
public class GameMap {
    ArrayList<Polygon> gons = new ArrayList();
    int size;
    int height;
    int width;
    
    public GameMap(int size, int width, int height) {
        this.size = size;
        
        this.height = height;
        this.width = width;
        
        int boxheight = height/size;
        int boxwidth = width/size;
       
        for (int i = 0; i < boxheight; i++) {
            for (int j = 0; j < boxwidth; j++) {
                if (true) {
                    int[] xPoints = {i*size,i*size*2};
                    int[] yPoints = {j*size,j*size*2};
                    Polygon p = new Polygon(xPoints, yPoints, 4);
                    gons.add(p);
                    
                }
                
            }
        }
        
        
    }
    
    
    public void drawMap(Graphics g){
        g.setColor(Color.red);
        for (Polygon p : gons) {
            g.fillPolygon(p);
        }
    }
    
}
