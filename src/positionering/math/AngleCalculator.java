package positionering.math;

import positionering.etc.Point;

/**
 * This class contains sourcecode to calculate an angle.
 *
 * @author Dion
 */
public class AngleCalculator {

    /**
     * The center of the output file.
     */
    public static final int CENTER_CAM = 640 / 2;

    /**
     * Creates an AngleCalculator object.
     */
    public AngleCalculator() {
    }

    /**
     * Calculates the angle between the center of the output file and the given
     * point.
     *
     * @param update the given point.
     * @return the angle.
     */
    public double update(Point update) {
        double angle;
        int AZ = update.x - CENTER_CAM;
        int OZ = update.y;
        angle = Math.atan2((double) OZ, (double) AZ);
        return (angle / Math.PI) * 180;
    }
}
