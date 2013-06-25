
package positionering.math;

import positionering.etc.Point;

/**
 *
 * @author Dion
 */
public class AngleCalculator {
    
    /** Het midden van de .jpeg inputfile
     * 
     */
    public static final int CENTER_CAM = 640/2;
    
    /** Constructur zonder parameters
     * 
     */
    public AngleCalculator(){   
    }
    
    
    /** Berekent de hoek tussen het midden van de .jpeg inputfile en het
     *  gevonden punt.
     * @param update het gevonden punt.
     * @return de hoek
     */
    public double update(Point update){
        double angle;
        int AZ = update.x - CENTER_CAM;
        int OZ = update.y;
        angle = Math.atan2((double)OZ,(double)AZ);          
        return (angle/Math.PI)*180;
    }
    
}
