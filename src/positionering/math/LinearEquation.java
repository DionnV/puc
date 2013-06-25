
package positionering.math;

import positionering.etc.Point;

/**
 *
 * @author Dion
 */
public class LinearEquation {

    private double slope;
    private double b;

    /** Maakt een lineaire vergelijking met een helling en een constante b.
     * 
     * @param slope de helling.
     * @param b de constante.
     */
    public LinearEquation(double slope, double b) {
        this.slope = slope;
        this.b = b;
    }

    /** Maakt een lineaire vergelijking aan de hand van de helling en een punt.
     * 
     * @param slope de helling.
     * @param p het punt.
     * @return een lineaire vergelijking in de vorm van y = ax + b.
     */
    public static LinearEquation createWithPoint(double slope, Point p) {
        if (p.x == 0) {
            return new LinearEquation(slope, p.y);
        } else if(p.y == 0){
            return new LinearEquation(slope, -(double) (slope * p.x));
        }else {
            return new LinearEquation(slope,  p.y / (double) (slope * p.x));
        }
    }

    /** Zoekt het snijpunt tussen twee lineaire vergelijkingen.
     * 
     * @param le1 y = ax + b
     * @param le2 y = cx + d
     * @return De oplossing van de twee vergelijkingen.
     */
    public static Point solve(LinearEquation le1, LinearEquation le2) {
        if (le1.slope == le2.slope) {
            System.out.println("Error: parrallel lines");
            return null;
        }
        Point res = new Point();
        res.x = (int) ((le2.b - le1.b) / (le1.slope - le2.slope));
        res.y = (int) (le1.slope * res.x + le1.b);
        return res;
    }

    
    @Override
    /** Retourneert een Stringrepresentatie van een lineaire vergelijking
     * 
     */
    public String toString() {
        return "y = " + slope + "x + " + b;
    }
}
