/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
/**
 *
 * @author Owner
 */
public class CanvasGUI {
    public String fractalType = "custom";
    //create the Canvas
    private Canvas c = new Canvas();
    //get the canvas's Graphics to draw with
    private Graphics g = c.getGraphics();
    //add features to GUI to allow for zoom, color changing, and more
    //constructor
    public CanvasGUI(){
        //Creating the Frame
        JFrame frame = new JFrame("Fractal Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        //Creating the MenuBar and save as button
        JMenuBar mb = new JMenuBar();
        JMenu save = new JMenu("Save as");
        mb.add(save);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter desired fractal type");
        JTextField textField = new JTextField(10); // accepts upto 10 characters
        JButton enterType = new JButton("Enter");
        JButton resetText = new JButton("Reset");
        
        // Components added to the bottom panel using Flow Layout
        panel.add(label); 
        panel.add(textField);
        panel.add(enterType);
        panel.add(resetText);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, c);
        frame.setVisible(true);
    }
    
    //class setters
    public void stroke(Color theColor) {
        g.setColor(theColor);
    }
    public void setBackground(Color theColor) {
        c.setBackground(theColor);
    }
    public void line(int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }
    public void circle(int x, int y, int r) {
        Graphics2D g2 = (Graphics2D) g;
        Shape circle = new Ellipse2D.Double(x, y, r, r);
        g2.draw(circle);
    }
    public void rect(int x1, int y1, int x2, int y2) {
        Graphics2D g2 = (Graphics2D) g;
        Shape rect = new Rectangle(x1, y1, x2, y2);
        g2.draw(rect);
    }
    
    //class getters
    //other methods
    
    //toString returns current fractal type
    public String toString() {
        return fractalType;
    }
}
