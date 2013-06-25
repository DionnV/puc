/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package positionering.etc;

/**
 *
 * @author Dion
 */
public class Point {
    
    public int x;
    public int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
