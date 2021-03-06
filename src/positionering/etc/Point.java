package positionering.etc;

/**
 * This class contains sourcecode to create a 2-dimensional point.
 *
 * @author Dion
 */
public class Point extends Object{

    public int x;
    public int y;

    /**
     * Creates a Point-object
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public Point(){
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point punt){
        this.x = punt.x;
        this.y = punt.y;
    }

    /**
     * Returns the x-coordinate as a double.
     *
     * @return the x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate as a double.
     *
     * @return the y-coordinate.
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
