/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heading;

import positionering.etc.Point;
/**
 *
 * @author CKCHOI
 */
public class CalculateHeading {

    //public CalculateHeading(double x1, double y1, double x2, double y2) {
    public CalculateHeading(Point p1, Point p2) {
        Point A = p1;
        Point B = p2;
        
        double angle;
        //double aZ = yB - yA;
        double aZ = p2.y - p1.y;
        //double sZ = Math.sqrt((Math.pow((yB - yA), 2)) + (Math.pow((xB - xA), 2)));
        double sZ = Math.sqrt((Math.pow((p2.y - p1.y), 2)) + (Math.pow((p2.x - p1.x), 2)));
        angle = Math.toDegrees(Math.acos(aZ / sZ));
        //if (xB - xA < 0.0) {
        if (p2.x - p1.x < 0.0) {
            angle = 360 - angle;
        }
        System.out.println("Angle = " + angle);
    }
}
