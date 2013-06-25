
package positionering.math;

import positionering.etc.Point;
import positionering.etc.PointCollection;

/**
 *
 * @author Dion
 */
public class PositionCalculator {
    
    PointAlgorithm pa;
    PointCollection pc;

    //Positie van de cams in het virtuele vlak 
    //Vlak is 1280 bij 800
    public static final Point FIXED_CAM1_POS = new Point(0, 10);
    public static final Point FIXED_CAM2_POS = new Point(10, 0);
    public static final Point FIXED_CAM3_POS = new Point(1050, 0);
    public static final Point FIXED_CAM4_POS = new Point(1060, 10);
    public static final Point FIXED_CAM5_POS = new Point(1060, 785);
    public static final Point FIXED_CAM6_POS = new Point(1050, 795);
    public static final Point FIXED_CAM7_POS = new Point(10, 795);
    public static final Point FIXED_CAM8_POS = new Point(0, 785);
           
    //Kijkhoek camera is 60 graden maar geeft 180 graden beeld.
    //scaling = 60/180 = 0.3
    /**
     * De schaling van de kijkhoek
     */
    public static final double scaling = 0.33333;
    
    //Cams staat standaard gedraaid
    /**
     * De rotatie van de camera's
     */
    public static final int FIXED_CAM1_ROTATION = 30;
    public static final int FIXED_CAM2_ROTATION = 0;
    public static final int FIXED_CAM3_ROTATION = 120;
    public static final int FIXED_CAM4_ROTATION = 90;
    public static final int FIXED_CAM5_ROTATION = 210;
    public static final int FIXED_CAM6_ROTATION = 180;
    public static final int FIXED_CAM7_ROTATION = 300;
    public static final int FIXED_CAM8_ROTATION = 270;

    /** Een constructor zonder parameters
     * 
     */
    public PositionCalculator() {
        //constructor to initialize
    }

    /** Berekent de positie aan de hand van vier hoeken en de 
     *  ingevoerde positie en rotatie.
     * @param cam1_angle De hoek van camera 1.
     * @param cam2_angle De hoek van camera 2.
     * @param cam3_angle De hoek van camera 3.
     * @param cam4_angle De hoek van camera 4.
     * @return Het gevonden punt.
     */
    public Point calcPosition(double cam1_angle, double cam2_angle, double cam3_angle, double cam4_angle, double cam5_angle, double cam6_angle, double cam7_angle, double cam8_angle) {
        //Schaal hoek met de scaling
        cam1_angle *= scaling;
        cam2_angle *= scaling;
        cam3_angle *= scaling;
        cam4_angle *= scaling;
        cam5_angle *= scaling;
        cam6_angle *= scaling;
        cam7_angle *= scaling;
        cam8_angle *= scaling;

        //Tel de fixed rotation bij de geschaalde hoek op
        cam1_angle += FIXED_CAM1_ROTATION;
        cam2_angle += FIXED_CAM2_ROTATION;
        cam3_angle += FIXED_CAM3_ROTATION;
        cam4_angle += FIXED_CAM4_ROTATION;
        cam5_angle += FIXED_CAM1_ROTATION;
        cam6_angle += FIXED_CAM2_ROTATION;
        cam7_angle += FIXED_CAM3_ROTATION;
        cam8_angle += FIXED_CAM4_ROTATION;

        //Maak lineaire lijn
        LinearEquation le1 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam1_angle)), FIXED_CAM1_POS);
        LinearEquation le2 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam2_angle)), FIXED_CAM2_POS);
        LinearEquation le3 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam3_angle)), FIXED_CAM3_POS);
        LinearEquation le4 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam4_angle)), FIXED_CAM4_POS);
        LinearEquation le5 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam5_angle)), FIXED_CAM5_POS);
        LinearEquation le6 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam6_angle)), FIXED_CAM6_POS);
        LinearEquation le7 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam7_angle)), FIXED_CAM7_POS);
        LinearEquation le8 = LinearEquation.createWithPoint(Math.tan(Math.toRadians((double) cam8_angle)), FIXED_CAM8_POS);

        //Maak een PointCollection met intersecties
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
