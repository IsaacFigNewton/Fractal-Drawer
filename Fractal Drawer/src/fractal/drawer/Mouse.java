/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Owner
 */
class Mouse extends Frame implements MouseListener { 
  
    // Jlabels to display the actions of events of mouseListener 
    // static JLabel label1, label2, label3; 
  
    // default constructor 
    Mouse() 
    { 
    } 
  
    
  
    // getX() and getY() functions return the 
    // x and y coordinates of the current 
    // mouse position 
    // getClickCount() returns the number of 
    // quick consecutive clicks made by the user 
  
    // this function is invoked when the mouse is pressed 
    public void mousePressed(MouseEvent e) 
    { 
        
    } 
  
    // this function is invoked when the mouse is released 
    public void mouseReleased(MouseEvent e) 
    { 
        
    } 
  
    // this function is invoked when the mouse exits the component 
    public void mouseExited(MouseEvent e) 
    { 
        FractalDrawer.inCanvas = false;
    } 
  
    // this function is invoked when the mouse enters the component 
    public void mouseEntered(MouseEvent e) 
    { 
        FractalDrawer.inCanvas = true;
    } 
  
    // this function is invoked when the mouse is pressed or released 
    public void mouseClicked(MouseEvent e) 
    { 
        //use this method to use the toggle button
        
        // getClickCount gives the number of quick, 
        // consecutive clicks made by the user 
        // show the point where the mouse is i.e 
        // the x and y coordinates 
//        label3.setText("mouse clicked at point:"
//                       + e.getX() + " "
//                       + e.getY() + "mouse clicked :" + e.getClickCount()); 
    }
     
} 
