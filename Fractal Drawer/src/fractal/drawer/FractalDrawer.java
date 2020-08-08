/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;

//import images.APImage;
//import images.Pixel;
//import java.io.*;
import fractal.drawer.*;
import fractal.drawer.Mouse;
import fractal.drawer.Mouse2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
/**
 *
 * @author Owner
 */
public class FractalDrawer {
//    public static APImage theImage = new APImage("placeholder.jpg");
    
    /**
     * @param args the command line arguments
     */
    //create the Canvas
    private static Canvas c = new Canvas();
    // create a mouse listener
    public static Mouse borders = new Mouse();
    public static Mouse2 location = new Mouse2(); 
    //save the mouse's location within the canvas
    public static int mouseX = 0;
    public static int mouseY = 0;
    public static boolean inCanvas = false;
    
    public static void main(String[] args) {
        //create the GUI and canvas
        //Creating the Frame
        JFrame frame = new JFrame("Fractal Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        //Creating the MenuBar and save as button
        JMenuBar mb = new JMenuBar();
        JButton save = new JButton("Save As");
        mb.add(save);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Fractal-Drawing Method");
        JButton lineType = new JButton("Line");
        JButton shapeType = new JButton("Shape/Add Lobe");
        JButton addRecursionSize = new JButton("Increase Recursion Size");
        JButton removeRecursionSize = new JButton("Decrease Recursion Size");
        
        // Components added to the bottom panel using Flow Layout
        panel.add(label);
        panel.add(lineType);
        panel.add(shapeType);
        panel.add(addRecursionSize);
        panel.add(removeRecursionSize);
        
        // add mouseListener and mouseMotionListeners to the frame 
        frame.addMouseListener(borders);
        frame.addMouseMotionListener(location);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, c);
        frame.setVisible(true);
        //set the canvas up
        stroke(Color.BLACK);
        setBackground(Color.WHITE);
        
        //draw on the canvas
        //infinite loop drawing because apparently the program hates single-time drawing
        while (true) {
            //update mouse location
            Mouse2.mouseMoved(location);
            line((1*getCanvasWidth())/8, (1*getCanvasHeight())/8, (7*getCanvasWidth())/8, (7*getCanvasHeight())/8);
               
            //a circle
            circle(getCanvasWidth()/2-20, getCanvasHeight()/2-20, mouseX);
        
        }
        
        //Take user input for desired fractal among list of fractals or just have user drag line to make fractal
        
    }
    
    //class getters
    public static Canvas getCanvas() {
        return c;
    }
    public static int getCanvasWidth() {
        return c.getWidth();
    }
    public static int getCanvasHeight() {
        return c.getHeight();
    }
    
    
    //class setters
    public static void stroke(Color theColor) {
        c.getGraphics().setColor(theColor);
    }
    public static void setBackground(Color theColor) {
        c.setBackground(theColor);
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
    public static void rect(int x1, int y1, int x2, int y2) {
        Graphics2D g2 = (Graphics2D) c.getGraphics();
        Shape rect = new Rectangle(x1, y1, x2, y2);
        g2.draw(rect);
    }

    //other methods
    
    //toString returns current fractal type
    public String toString() {
        return "";
    }
    
}

/*                                 sources:
Template:           SLOHS, SLO, CA.
Drawing tools:      I don't remember
Mouse events:       https://www.geeksforgeeks.org/mouselistener-mousemotionlistener-java/

*/

