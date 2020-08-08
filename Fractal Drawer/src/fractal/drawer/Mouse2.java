/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Owner
 */
class Mouse2 extends Frame implements MouseMotionListener {
    public Mouse2 () {
        
    }
    
    
    public void mouseMoved(MouseEvent e) {
        if (FractalDrawer.inCanvas == true) {
            FractalDrawer.mouseX = e.getX();
            FractalDrawer.mouseY = e.getY();
        } else {
            //don't store current mouse position
        }
    }
    
    public void mouseDragged(MouseEvent e) 
    { 
        // update the label to show the point 
        // through which point mouse is dragged 
        
    }
}
