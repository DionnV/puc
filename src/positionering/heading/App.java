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
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Point A = new Point(1,4);
        Point B = new Point(0,4);
        CalculateHeading c = new CalculateHeading(A, B);
    }
}
