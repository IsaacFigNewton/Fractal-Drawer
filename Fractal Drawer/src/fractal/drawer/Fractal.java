/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;

import fractal.drawer.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author Owner
 */
public class Fractal {
    private static Canvas c = new Canvas();
    public static int type = 0;
    public static int recursions = 20;
    public static int lobeCount = 1;
    public static int size = 25;
    
    public Fractal(Canvas canvas) {
        c = canvas;
    }
    
    //draw fractal each iteration
    public static void draw(Canvas canvas, int x, int y) {
        c = canvas;
        
        //draw the line and regular line fractal
        if (type == 0) {
            //get end points of lines
            int startX = c.getWidth()/8;
            int startY = (7*c.getHeight())/8;
            int endX = (7*c.getWidth())/8;
            int endY = (7*c.getHeight())/8;
            
            int xRelToStart = x - startX;
            int yRelToStart = y - startY;
            
            //make lines
            line(startX, startY, x, y);
            line(x, y, endX, endY);
            
            //draw fractal
            /*
                Pseudocode:

                //iteration 1
                    int startX = c.getWidth()/8;
                    int startY = c.getHeight()/2;
                    int endX = (7*c.getWidth())/8;
                    int endY = c.getHeight()/2;
            
                    line(startX, startY, startX + xRelToStart, startY + yRelToStart);
                    line(startX + xRelToStart, startY + yRelToStart, endX, endY);
                //iteration 2
                    int startX = c.getWidth()/8;
                    int startY = c.getHeight()/2;
                    int endX = (7*c.getWidth())/8;
                    int endY = c.getHeight()/2;
            
                    //something's wrong, I can feel it
                    line(startX, startY, startX + xRelToStart/2, startY + yRelToStart/2);
                    line(startX + xRelToStart/2, startY + yRelToStart/2, startX + (2*xRelToStart)/2, startY + (2*yRelToStart)/2);
                    line(startX + (2*xRelToStart)/2, startY + (2*yRelToStart)/2, startX + (3*xRelToStart)/2, startY + (3*yRelToStart)/2);
                    line(startX + (3*xRelToStart)/2, startY + (3*yRelToStart)/2, endX, enxY);
            */
            for(int i = 0; i < recursions; i++) {
                
            }
            
        //draw a circle fractal with lobeCount # lobes
        } else if (type == 1) {
            circle(x, y, size);
        //draw a square fractal with lobeCount # lobes x4
        } else if (type == 2){
            rect(x, y, size, size);
        } else {
            System.out.println("error choosing fractal drawing type");
        }
        
        
    }
    
    //class drawing tools
    public static void line(int x1, int y1, int x2, int y2) {
        c.getGraphics().drawLine(x1, y1, x2, y2);
    }
    public static void circle(int x, int y, int r) {
        Graphics2D g2 = (Graphics2D) c.getGraphics();
        Shape circle = new Ellipse2D.Double(x, y, r, r);
        g2.draw(circle);
    }
    public static void rect(int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) c.getGraphics();
        Shape rect = new Rectangle(x, y, x + width, y + height);
        g2.draw(rect);
    }
}
