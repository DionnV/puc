/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package positionering.heading;

import java.awt.Point;

/**
 *
 * @author CKCHOI
 */

public class CalculateHeading {

    private double angle;
    private double aZ;
    private double sZ;
    private Point front;
    private Point back;
    
    /**
     * Calculates the angle of the ship, relative to north
     * @param front The coordinates of the point at the front
     * @param back The coordinates of the point at the back
     */
    public CalculateHeading(Point front, Point back) {
        this.front = front;
        this.back = back;
        
        aZ = front.y - back.y;
        sZ = Math.sqrt((Math.pow((back.y - front.y), 2)) + (Math.pow((back.x - front.x), 2)));
        angle = Math.toDegrees(Math.acos(aZ / sZ));
        if (aZ < 0.0 && sZ > 0.0) {
            angle = 360 - angle;
        }
        System.out.println("Angle = " + angle);
    }
    
    /**
     * Prints the direction of the ship
     */
    public void printDirection(){
        if (angle > 0 && angle < 90){
            System.out.println("NorthEast");
        } else if (angle > 90 && angle < 180){
            System.out.println("SouthEast");
        } else if (angle > 180 && angle < 270){
            System.out.println("SouthWest");
        } else if (angle > 270 && angle < 360){
            System.out.println("NorthWest");
        } else if (angle == 0){
            System.out.println("North");
        } else if (angle == 90){
            System.out.println("East");
        } else if (angle == 180){
            System.out.println("South");
        } else if (angle == 270){
            System.out.println("West");
        }
    }
}
