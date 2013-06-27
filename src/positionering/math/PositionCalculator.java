package positionering.math;

import positionering.etc.Point;
import positionering.etc.PointCollection;

/**
 * This class contains sourcecode to calculate the position in a (1060, 795)
 * space, given the angle of 8 cameras.
 *
 * @author Dion
 */
public class PositionCalculator {

    /**
     * These static final Point objects contain the fixed position of the
     * cameras in the (1060, 795) space.
     */
    public static final Point FIXED_CAM1_POS = new Point(0, 10);
    public static final Point FIXED_CAM2_POS = new Point(10, 0);
    public static final Point FIXED_CAM3_POS = new Point(1050, 0);
    public static final Point FIXED_CAM4_POS = new Point(1060, 10);
    public static final Point FIXED_CAM5_POS = new Point(1060, 785);
    public static final Point FIXED_CAM6_POS = new Point(1050, 795);
    public static final Point FIXED_CAM7_POS = new Point(10, 795);
    public static final Point FIXED_CAM8_POS = new Point(0, 785);
    /**
     * This static final double contains the scaling of the cameras. This is
     * equal to 180 divided by the camera viewing anlge, which is 60 degrees in
     * this case.
     */
    public static final double scaling = 0.33333;
    /**
     * These static final int objects contain the fixed rotation of the cameras.
     */
    public static final int FIXED_CAM1_ROTATION = 30;
    public static final int FIXED_CAM2_ROTATION = 0;
    public static final int FIXED_CAM3_ROTATION = 120;
    public static final int FIXED_CAM4_ROTATION = 90;
    public static final int FIXED_CAM5_ROTATION = 210;
    public static final int FIXED_CAM6_ROTATION = 180;
    public static final int FIXED_CAM7_ROTATION = 300;
    public static final int FIXED_CAM8_ROTATION = 270;
    private PointAlgorithm pa;
    private PointCollection pc;

    /**
     * Creates a PositionCalculator object.
     */
    public PositionCalculator() {
    }

    /**
     * Calculates the position in the (1060, 795) space given all 8 camera
     * angles.
     *
     * @param cam1_angle the angle of camera 1.
     * @param cam2_angle the angle of camera 2.
     * @param cam3_angle the angle of camera 3.
     * @param cam4_angle the angle of camera 4.
     * @param cam5_angle the angle of camera 5.
     * @param cam6_angle the angle of camera 6.
     * @param cam8_angle the angle of camera 7.
     * @param cam7_angle the angle of camera 8.
     * @return the Point containing the found x- and y-coordinates.
     */
    public Point calcPosition(double cam1_angle, double cam2_angle, double cam3_angle, double cam4_angle, double cam5_angle, double cam6_angle, double cam7_angle, double cam8_angle) {
        cam1_angle *= scaling;
        cam2_angle *= scaling;
        cam3_angle *= scaling;
        cam4_angle *= scaling;
        cam5_angle *= scaling;
        cam6_angle *= scaling;
        cam7_angle *= scaling;
        cam8_angle *= scaling;

        cam1_angle += FIXED_CAM1_ROTATION;
        cam2_angle += FIXED_CAM2_ROTATION;
        cam3_angle += FIXED_CAM3_ROTATION;
        cam4_angle += FIXED_CAM4_ROTATION;
        cam5_angle += FIXED_CAM1_ROTATION;
        cam6_angle += FIXED_CAM2_ROTATION;
        cam7_angle += FIXED_CAM3_ROTATION;
        cam8_angle += FIXED_CAM4_ROTATION;

        LinearEquation le1 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam1_angle)), FIXED_CAM1_POS);
        LinearEquation le2 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam2_angle)), FIXED_CAM2_POS);
        LinearEquation le3 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam3_angle)), FIXED_CAM3_POS);
        LinearEquation le4 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam4_angle)), FIXED_CAM4_POS);
        LinearEquation le5 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam5_angle)), FIXED_CAM5_POS);
        LinearEquation le6 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam6_angle)), FIXED_CAM6_POS);
        LinearEquation le7 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam7_angle)), FIXED_CAM7_POS);
        LinearEquation le8 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam8_angle)), FIXED_CAM8_POS);
               

        pc = new PointCollection();
        pc.add(LinearEquation.solve(le1, le3));
        pc.add(LinearEquation.solve(le1, le4));
        pc.add(LinearEquation.solve(le1, le7));
        pc.add(LinearEquation.solve(le1, le8));
        pc.add(LinearEquation.solve(le2, le3));
        pc.add(LinearEquation.solve(le2, le4));
        pc.add(LinearEquation.solve(le2, le7));
        pc.add(LinearEquation.solve(le2, le8));
        pc.add(LinearEquation.solve(le3, le5));
        pc.add(LinearEquation.solve(le3, le6));
        pc.add(LinearEquation.solve(le4, le5));
        pc.add(LinearEquation.solve(le4, le6));
        pc.add(LinearEquation.solve(le5, le7));
        pc.add(LinearEquation.solve(le5, le8));
        pc.add(LinearEquation.solve(le6, le7));
        pc.add(LinearEquation.solve(le6, le8));

        pa = new PointAlgorithm(pc);

        return pa.process();
    }
}
