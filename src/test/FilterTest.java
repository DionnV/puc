
package test;

import positionering.javacv.TargetFinder;

/**
 *
 * @author Dion
 */
public class FilterTest {

    public static void main(String[] args) {
        positionering.javacv.Calibration.calibrate();
        System.out.println("Pink bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.pink_bgr));
        System.out.println("Purple bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.purple_bgr));
        System.out.println("Orange bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.orange_bgr));
        System.out.println("Yellow bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.yellow_bgr));
        System.out.println("Cyan bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.cyan_bgr));
        System.out.println("Green bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.green_bgr));
        System.out.println("Beige bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.beige_bgr));
        System.out.println("Blue bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.blue_bgr));
        
        TargetFinder tf = new TargetFinder();
        tf.setTargetColor(new int[]{0, 0, 241, 0}, new int[]{122, 133, 255, 0});
        tf.loadAndSave("C:/Imtech/Posipics/calibrate/test.jpg");
    }
}
