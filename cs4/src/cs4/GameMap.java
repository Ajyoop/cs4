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
    //VEt inte vad som hände med mappen, den sluta fungera när jag la upp allt på github
    //Det den gjorde innan var iallafall att skapa ett random rutnät av polygonfyrkanter
    public GameMap(int size, int width, int height) {
        this.size = size;
        this.height = height;
        this.width = width;
        
        int boxheight = height/size;
        int boxwidth = width/size;
        System.out.println(boxwidth);
        for (int i = 0; i < boxwidth; i++) {
            for (int j = 0; j < boxheight; j++) {
                double z = Math.random()*10;
                if(z > 0.1) {
                    int[] xPoints = {i*size,i*size*2,i*size*2,i*size};
                    System.out.println(j*size+","+j*size*2);
                    int[] yPoints = {j*size,j*size,j*size*2,j*size*2};
                    System.out.println(i*size+","+i*size*2);
                    Polygon p = new Polygon(xPoints, yPoints, 4);
                    gons.add(p);
                    
                    
                }
                
            }
        }
        
        
    }
    
    
    public void drawMap(Graphics g){
        g.setColor(Color.black);
        for (Polygon p : gons) {
            g.fillPolygon(p);
            //System.out.println("POLYONOOOOOAS");
        }
    }
    
}
