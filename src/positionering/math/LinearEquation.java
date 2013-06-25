package positionering.math;

import positionering.etc.Point;

/**
 * This class contains sourcecode to create a linear equation.
 *
 * @author Dion
 */
public class LinearEquation {

    private double slope;
    private double b;

    /**
     * Creates a LinearEquation object.
     *
     * @param slope the slope.
     * @param b the constant.
     */
    public LinearEquation(double slope, double b) {
        this.slope = slope;
        this.b = b;
    }

    /**
     * Creates a LinearEquation object given a Point and a slope.
     *
     * @param slope the slope.
     * @param p the given Point.
     * @return a LinearEquation.
     */
    public static LinearEquation createWithPoint(double slope, Point p) {
        if (p.x == 0) {
            return new LinearEquation(slope, p.y);
        } else if (p.y == 0) {
            return new LinearEquation(slope, -(double) (slope * p.x));
        } else {
            return new LinearEquation(slope, p.y / (double) (slope * p.x));
        }
    }

    /**
     * Solves an equation of two linear lines.
     *
     * @param le1 y = ax + b
     * @param le2 y = cx + d
     * @return the outcome of the equation in a Point object.
     */
    public static Point solve(LinearEquation le1, LinearEquation le2) {
        if (le1.slope == le2.slope) {
            System.out.println("Error: parrallel lines");
            return null;
        }
        int x = (int) ((le2.b - le1.b) / (le1.slope - le2.slope));
        int y = (int) (le1.slope * x + le1.b);
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "y = " + slope + "x + " + b;
    }
}
