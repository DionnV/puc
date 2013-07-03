package positionering.gui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
//import positionering.etc.Point;
import positionering.etc.Point;

/**
 * @author Bart Simons
 */
public class Boot {
    //FIELDS
    private int x;
    private int y;
    private int width = 20;
    private int heigth = 50;
    private int index;
    private Color kleur;
    private int[] pastX = new int[31];
    private int[] pastY = new int[31];
    private int lastPast;
    private double heading;
    public Rectangle rBoat;
    public Shape Boat;
    
    //CONSTRUCTORS
    /**
     *  Empty constructor.
     */
    public Boot(){
        
    }
    
    /**
     * Constructor that makes a filled boat.
     * @param x the x-coordinate of the boat.
     * @param y the y-coordinate of the boat.
     * @param i the index of the boat. This also determines in which color the boat will be drawn.
     */
    public Boot(Point front, Point back, int i){
        heading =  calculateHeading(front, back);
        Point middle = new Point(calculateMiddle(front, back));
        setX(middle.x);
        setY(middle.y);
        setIndex(i);
        setKleur();
        createBoatImage(heading);
        lastPast = 0;
        pastX[lastPast] = x;
        pastY[lastPast] = y;
    }
    
    /**
     * Use this to update the position and heading of an already existing boat.
     * @param x the new x-coordinate of the boat
     * @param y the new y-coordinate of the boat
     * @param heading the new heading of the boat
     * This function also saves the last position in an array. This is used
     * to draw a historical line in the GUI
     */
    public void updateBoot(Point front, Point back){
        if(lastPast < 30){
            heading =  calculateHeading(front, back);
            Point middle = new Point(calculateMiddle(front, back));
            pastX[lastPast] = getX();
            pastY[lastPast] = getY();
            setX(middle.x);
            setY(middle.y);
            createBoatImage(heading);
        } else{
            lastPast = 0;
            heading =  calculateHeading(front, back);
            Point middle = new Point(calculateMiddle(front, back));
            pastX[lastPast] = x;
            pastY[lastPast] = y;
            setX(middle.x);
            setY(middle.y);
            createBoatImage(heading);
        }
    }

    /**
     * @return the current x-coordinate of the boat.
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x-coordinate to set
     */
    public void setX(int x) {
        x = x-(width/2);
        this.x = x;
    }

    /**
     * @return the current y-coordinate of the boat.
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y-coordinate of the boat to set.
     */
    public void setY(int y) {
        y = y-(heigth/2);
        this.y = y;
    }

    /**
     * @return the width of the boat (for drawing purposes)
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the heigth of the boat (for drawing purposes)
     */
    public int getHeigth() {
        return heigth;
    }

    /**
     * @return the index of the boat
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index of the boat (only change when creating a new boat)
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the color of the boat.
     */
    public Color getKleur() {
        return kleur;
    }
    
    public Point getPastPosition(int i){
        return new Point(pastX[i],pastY[i]);
    }

    /**
     * This function determines the color of the boat based on the index.
     */
    public void setKleur() {
        if(index==0){
            kleur = Color.GREEN;
        }else if(index==1){
           kleur = Color.YELLOW;
        }else if(index==2){
           kleur = Color.ORANGE;
        }else{
           kleur = Color.BLACK; 
        }
    }

    /**
     * @return the heading of this boat in degrees
     */
    public double getHeading() {
        return heading;
    }

    /**
     * Sets heading and creates rotated rectangle for immediate drawing.
     * @param heading the heading to set of this in degrees
     */
    public void createBoatImage(double heading) {
        rBoat = new Rectangle(getX(),getY(),width,heigth);
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(heading),((double)getX()+width/2),((double)getY()+heigth/2));
        System.out.println(getY());
        Boat = transform.createTransformedShape(rBoat);
    }
    public double calculateHeading(Point front, Point back){
        return positionering.heading.Heading.calc(front, back);
    }
    
    public Point calculateMiddle(Point front, Point back){
        Point middle = new Point();
        middle.x = (int)((front.x+back.x)/2);
        middle.y = (int)((front.y+back.y)/2);
        return middle;
    }
    
    
}
