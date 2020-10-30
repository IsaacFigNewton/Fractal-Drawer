/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal.drawer;

import fractal.drawer.*;
import static fractal.drawer.FPointList.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author Owner
 */
public class Fractal {
    private static Canvas c = new Canvas();
    public static Graphics2D ctx = (Graphics2D) c.getGraphics();
    public static int type = 0;
    public static int recursions = 10;
    public static int lobeCount = 2;
    public static int size = 100;
        
    //Ben Harding's Code here
    //constants
    public static int RecursiveConstructerLength = 700;
    public static double startAngle = 7 * Math.PI / 4;
    public static double startLength = Math.sqrt(2) * 350;

    //initializing things
    public static int mouseX = 400;
    public static int mouseY = 350;
    public static int x = 0;
    public static int y = 0;
    public static int originX = 0;
    public static int originY = 0;
    
    public static int flipA = 2;
    public static int flipB = 2;

    public static double fracAngle = startAngle;
    public static double fracLength = startLength;
    public static double angle = startAngle;
    public static double length = startLength;

    public static Point [] pointArray;
    public static int currentPoint = 0;
    public static int iterations = 7;
    public static int currentType;
    public static Fractal fractal;

    public static Point nextPoint;
    
    public static int screen = 1;

//    BaseList;
//    recList;
//    recEnd;
    
    public Fractal(Fractal f, Point nextP) {
        fractal = f;
        nextPoint = nextP;
    }
    
    public Fractal (int centerX, int centerY, Point [] base, int recurse, int flipB, int [] points, int startingPoint, int iterations) {
        //add stuff here
    }
    
    //class drawing tools
    public static void stroke(Color theColor) {
        c.getGraphics().setColor(theColor);
    }
    public static void moveTo(int X, int Y) {
        originX = X;
        originY = Y;
    }
    public static void line(int x1, int y1, int x2, int y2) {
        c.getGraphics().drawLine(originX + x1, originX + y1, originX + x2, originX + y2);
    }
    public static void circle(int x, int y, int r) {
        Graphics2D g2 = (Graphics2D) c.getGraphics();
        Shape circle = new Ellipse2D.Double(originX + x, originX + y, r, r);
        g2.draw(circle);
    }
    public static void rect(int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) c.getGraphics();
        Shape rect = new Rectangle(originX + x, originX + y, width, height);
        g2.draw(rect);
    }
    public static void fillRect(int x1, int y1, int x2, int y2) {
        Graphics2D g2 = (Graphics2D) c.getGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(originX + x1, originX + y1, originX + x2, originX + y2);
    }
    public static void clearCanvas() {
        fillRect(0, 0, c.getWidth(), c.getHeight());
    }

    //basic Fractal tools
    public static double distance(int XA, int YA, int XB, int YB) {
        return Math.sqrt((XA - XB) * (XA - XB) + (YA - YB) * (YA - YB));
    }

    
    public static void draw() {
        // drawing code
        FractalLine base = new FractalLine(0, 300, 2);
        //, new FractalLine(2 * Math.PI / 3, 200, 2), new FractalLine(4 * Math.PI / 3, 200, 2)];
            FractalLine recurse = new FractalLine(fracAngle, fracLength, flipA);
            Fractal list = FPointList.makeFractal(250, 400, base, recurse, flipB, [], 1, iterations);

            //var foo = new FPointList(100, 100, new FractalLine(0, 200, 2));
            //var fee = new FPointList(100, 100, new FractalLine(0, 0, 0))
            //foo.replaceLine(fee,recurse,3);
            moveTo(250, 400);
            Fractal drawing = list;
        while (drawing != null) {
            line(0, 0, x, y);
            //window.alert(drawing.angle*180/Math.PI + " " + drawing.length);
            drawing = new Fractal(drawing, nextPoint);
        }

        moveTo(50, 700);
        line(0, 0, mouseX, mouseY);
        line(0, 0, 750, 700);
        stroke(Color.BLACK);

    }

    public static void flipOne() {
        if (flipA == 2) {
            flipA = 3;
        } else {
            flipA = 2;
        }
        draw();
    }

    public static void flipTwo() {
        if (flipB == 2) {
            flipB = 3;
        } else {
            flipB = 2;
        }
        draw();
    }
    
    public static void setType(int to) {
        currentType = to;
    }

    public static FractalLine makeFLine(int AX, int AY, int BX, int BY, int type) {
        double length = distance(BX, BY, AX, AY);
        int delX = (int) FractalLine.prevFPoint.getX() - BX;
        int delY = (int) FractalLine.prevFPoint.getY() - BY;
        double angle = Math.atan(delY / delX);
        if (delX < 0 == Math.cos(angle) < 0) {
            angle += Math.PI;
        }
        return new FractalLine(angle, length, type);
    }

    public static void nextScreen() {
        newScreen((screen) % 3 + 1);
    }

    public static void newScreen(int newScreen) {
        screen = newScreen;
        Fractal.clearCanvas();
        if (newScreen == 1) {
            pointArray = null;
            BaseList = null;
            recList = null;
            recEnd = null;
            currentPoint = 0;
        } else if (newScreen == 2) {
            BaseList = pointArray;
            pointArray = makeFLine(0, 0, 400, 50, 0);
            currentPoint = 0;
        } else {
            recList = pointArray;
            recEnd = currentType;
            Fractal fractal = Fractal(0, 0, BaseList, recList, recEnd, [], 1);
        }
        drawScreen();
    }

    public static void drawScreen() {
        if (screen == 3) {
            moveTo(100, 300);
            Fractal drawing = fractal;
            while (drawing != null) {
                if (drawing.type != 0) {
                    ctx.lineTo(drawing.X, drawing.Y);

                }
                drawing = new Fractal(drawing,nextPoint);
            }

            stroke();
        }
    }

    public static void changeIterations(amount) {
        if (iterations + amount > 0);
        {
            iterations += amount;
            draw();
        }
    }

    public static void reset() {
        iterations = 7;
        flipA = 2;
        flipB = 2;
        fracAngle = startAngle;
        fracLength = startLength;
        draw();
    }
    
    //draw fractal each iteration
    public static void draw(Canvas c, int x, int y) {
        c = c;
        
        //draw the line and regular line fractal
        if (type == 0) {
            //draw a normal fractal
            
        //draw a circle fractal with lobeCount # lobes
        } else if (type == 1) {
            int dist = 0;
            circle(x, y, size);
            size /= lobeCount;
            for (int i = 0; i<recursions-1; i++) {
                circle(x + dist*lobeCount, y + dist*lobeCount, size);
//                size /= lobeCount;
                dist += size;
            }
            
        //draw a square fractal with lobeCount # lobes x4
        } else if (type == 2){
            rect(x, y, size, size);
        } else {
            System.out.println("error choosing fractal drawing type");
        }
        
        
    }
    
    //fractal tools
    public static double getAngle(int x1, int y1, int x2, int y2) {
        double angle = (double) Math.toRadians(Math.atan2(y1-y2, x1-x2));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
    public static void branch(int length) {
        
    }
}
class FractalLine{
    public static int type = 0;
    public static int recursions = 10;
    public static int lobeCount = 2;
    public static int size = 100;

    //Ben Harding's Code here
    //constants
    public static int RecursiveConstructerLength = 700;
    public static double startAngle = 7 * Math.PI / 4;
    public static double startLength = Math.sqrt(2) * 350;

    //initializing things
    public static int mouseX = 400;
    public static int mouseY = 350;
    public static int x = 0;
    public static int y = 0;
    public static int originX = 0;
    public static int originY = 0;

    public static int flipA = 2;
    public static int flipB = 2;

    public static double fracAngle = startAngle;
    public static double fracLength = startLength;
    public static double angle = startAngle;
    public static double length = startLength;

    public static Point[] pointArray;
    public static int currentPoint = 0;
    public static int iterations = 7;
    public static int currentType;
    public static Fractal fractal;
    public static Point prevFPoint;
    
    public FractalLine(double Angle, double Length, int Type) {
        type = Type;//type 0 is invisible, type 1 is normal. type 2 is left-hand recursive. type 3 is flipped recursive
        angle = Angle;
        length = Length;
    }

    public FractalLine makeInto(double tilt, double scalar, boolean isFlipped) {
        if (isFlipped) {
            return new FractalLine(tilt - angle, length * scalar, type);
        } else {
            return new FractalLine((tilt + angle), length * scalar, type);
        }
    }

    public Point findEnd(int X, int Y) {
        return new Point((int) (Math.cos(angle) * length + X),(int) (Math.sin(angle) * length + Y));
    }

}

class FPointList {
    public static int type = 0;
    public static int recursions = 10;
    public static int lobeCount = 2;
    public static int size = 100;

    //Ben Harding's Code here
    //constants
    public static int RecursiveConstructerLength = 700;
    public static double startAngle = 7 * Math.PI / 4;
    public static double startLength = Math.sqrt(2) * 350;

    //initializing things
    public static int mouseX = 400;
    public static int mouseY = 350;
    public static int x = 0;
    public static int y = 0;
    public static int originX = 0;
    public static int originY = 0;

    public static int flipA = 2;
    public static int flipB = 2;

    public static double fracAngle = startAngle;
    public static double fracLength = startLength;
    public static double angle = startAngle;
    public static double length = startLength;

    public static Point[] pointArray;
    public static int currentPoint = 0;
    public static int iterations = 7;
    public static int currentType;
    public static Fractal fractal;
    public Point nextPoint;
    
    public FPointList(int X, int Y, FractalLine FLine) {
        Point myPos = FLine.findEnd(X, Y);
        type = FLine.type;
        angle = FLine.angle;
        length = FLine.length;
        x = X;
        y = Y;
        nextPoint = null;
    }
    
    public static FPointList makeFractal(int X, int Y, Point [] baseL, Point [] recL, Point recLast, Point [] finL, Point finLast, int n) {
        //base list, recursive list, finishing list, iterations
        FPointList output = new FPointList(X, Y, new FractalLine(0, 0, 0));
        int i = 0;
        for (i = 0; i < baseL.length; i++) {
            output.add(baseL[i]);
        }
        FPointList current;
        FPointList next;
        for (i = 0; i < n - 1; i++) {
            current = output;
            while (current.nextPoint != null) {
                next = current.nextPoint;
                if (next.type > 1) {
                    next.replaceLine(current, recL, recLast);
                }
                current = next;
            }
        }

        current = output;
        while (current.nextPoint != null) {
            next = current.nextPoint;
            if (next.type > 1) {
                next.replaceLine(current, finL, finLast);
            }
            current.angle %= (2 * Math.PI);
            current = next;
        }
        return output;
    }
    

    public static FPointList getPoint(Point n) {
        if (n <= 0) {
            return new FPointList(x, y, new FractalLine(angle, length, type));
        } else if (nextPoint != null) {
            return nextPoint.getPoint(n - 1);
        } else {
            return null;
        }
    }

    public static void replaceLine(Point startFPoint, Point [] a, FractalLine fin) {
        //a = array of point objects, final = type of 'last' line
        Point prevFPoint = startFPoint;
        for (int i = 0; i < a.length; i++) {
            prevFPoint.nextPoint = new FPointList(prevFPoint.X, prevFPoint.Y, a[i].makeInto(angle, length / RecursiveConstructerLength, type == 3));
            prevFPoint = prevFPoint.nextPoint;
        }
        prevFPoint.nextPoint = this;
        length = distance(X, Y, prevFPoint.X, prevFPoint.Y);
        int delX = prevFPoint.X - X;
        int delY = prevFPoint.Y - Y;
        angle = Math.atan(delY / delX);
        if (delX < 0 == Math.cos(angle) < 0) {
            angle += Math.PI;
        }
        type = 1;
    }

    public static void add(Point point) {
        if (nextPoint == null) {
            nextPoint = new FPointList(X, Y, point);
        } else {
            nextPoint.add(point);
        }
    }
    
    public static 
}
