/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;

//import images.APImage;
//import images.Pixel;
//import java.io.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Owner
 */
public class FractalDrawer {
//    public static APImage theImage = new APImage("placeholder.jpg");
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //create the GUI and canvas
        CanvasGUI GUI = new CanvasGUI();
        
        //set the canvas up
        GUI.stroke(Color.BLACK);
        GUI.setBackground(Color.WHITE);
        
        //draw on the canvas
        GUI.line(100, 100, 400, 400);
        //Take user input for desired fractal among list of fractals or just have user drag line to make fractal
        
    }
    
}
