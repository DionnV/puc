
package test;

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
        System.out.println("Lightgreen bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.lightgreen_bgr));
        System.out.println("Blue bounds: " + java.util.Arrays.toString(positionering.javacv.Calibration.blue_bgr));
    }
}
