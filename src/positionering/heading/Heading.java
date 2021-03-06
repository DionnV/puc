package positionering.heading;

import positionering.etc.Point;

/**
 * This class contains sourcecode to calculate the heading between two Point
 * objects.
 *
 * @author Dion
 */
public class Heading {

    /**
     * This method will calculate the heading given two Point objects. The
     * heading will be given in degrees scaling from 0 - 360, with 0 being North,
     * 90 being East, 180 being South and 270 being West.
     *
     * @param front the front of the boat.
     * @param back the back of the boat.
     * @return an angle representing the heading.
     */
    public static double calc(Point front, Point back) {
        double angle = 90 - Math.toDegrees(Math.atan2((double) (front.y - back.y), (double) (front.x - back.x)));
        if (angle < 0) {
            angle = 360 + angle;
        }
        return angle;
    }
}
