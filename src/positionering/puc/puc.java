package positionering.puc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import positionering.etc.BoatState;
import positionering.etc.Point;
import positionering.javacv.Calibration;
import positionering.javacv.TargetFinder;
import positionering.math.AngleCalculator;
import positionering.math.PositionCalculator;

/**
 * This class contains the sourcecode of the puc - Positioning Using Cameras.
 *
 * @author Dion
 */
public class puc {

    /**
     * These static final String objects contain the IP-addresses of the
     * cameras.
     */
    private static final String CAM1_IP = "http://192.168.0.11";
    private static final String CAM2_IP = "http://192.168.0.12";
    private static final String CAM3_IP = "http://192.168.0.13";
    private static final String CAM4_IP = "http://192.168.0.14";
    private static final String CAM5_IP = "http://192.168.0.15";
    private static final String CAM6_IP = "http://192.168.0.16";
    private static final String CAM7_IP = "http://192.168.0.17";
    private static final String CAM8_IP = "http://192.168.0.18";
    /**
     * This static final String object contains the used port.
     */
    private static final String PORT = ":81";
    /**
     * This static final String object contains the snapshot suffix.
     */
    private static final String SNAPSHOT = "/snapshot.jpg";
    /**
     * These static final String objects contain the username and password to
     * log in the camera software.
     */
    private static final String USERNAME = "admin";
    private static final String PASS = "admin";
    /**
     * This static final String object contains the getrequest to access the
     * cameras.
     */
    private static final String AUTH = "?user=" + USERNAME + "&pwd=" + PASS;
    /**
     * This static final String object contains the path to the save location of
     * the snapshots.
     */
    private static final String PATH = "C:/Imtech/Posipics/";
    /**
     * These static final String object contain the id given to the snapshots
     * when saved.
     */
    private static final String CAM1_PIC_ID = "cam1id.jpg";
    private static final String CAM2_PIC_ID = "cam2id.jpg";
    private static final String CAM3_PIC_ID = "cam3id.jpg";
    private static final String CAM4_PIC_ID = "cam4id.jpg";
    private static final String CAM5_PIC_ID = "cam5id.jpg";
    private static final String CAM6_PIC_ID = "cam6id.jpg";
    private static final String CAM7_PIC_ID = "cam7id.jpg";
    private static final String CAM8_PIC_ID = "cam8id.jpg";
    /**
     * These static final int[] objects contain BRG-values; the first three are
     * for the minimum, the last three are for the maximum.
     */
    private static final int[] BOAT1_FRONT_COLOR = Calibration.orange_bgr;
    private static final int[] BOAT2_FRONT_COLOR = Calibration.purple_bgr;
    private static final int[] BOAT3_FRONT_COLOR = Calibration.blue_bgr;
    private static final int[] BOAT4_FRONT_COLOR = Calibration.cyan_bgr;
    private static final int[] BOAT1_BACK_COLOR = Calibration.yellow_bgr;
    private static final int[] BOAT2_BACK_COLOR = Calibration.pink_bgr;
    private static final int[] BOAT3_BACK_COLOR = Calibration.beige_bgr;
    private static final int[] BOAT4_BACK_COLOR = Calibration.green_bgr;
    private String cam1_snapshot = CAM1_IP + PORT + SNAPSHOT + AUTH;
    private String cam2_snapshot = CAM2_IP + PORT + SNAPSHOT + AUTH;
    private String cam3_snapshot = CAM3_IP + PORT + SNAPSHOT + AUTH;
    private String cam4_snapshot = CAM4_IP + PORT + SNAPSHOT + AUTH;
    private String cam5_snapshot = CAM5_IP + PORT + SNAPSHOT + AUTH;
    private String cam6_snapshot = CAM6_IP + PORT + SNAPSHOT + AUTH;
    private String cam7_snapshot = CAM7_IP + PORT + SNAPSHOT + AUTH;
    private String cam8_snapshot = CAM8_IP + PORT + SNAPSHOT + AUTH;
    public BoatState current_boat;
    public Point current_point;
    TargetFinder tf;
    AngleCalculator ac;
    PositionCalculator pc;
    int[] min;
    int[] max;
    private boolean running;

    /**
     * Creates a puc object.
     */
    public puc() {
    }

    /**
     * Initiates the main settings for puc.
     */
    public void initiate() {
        running = false;
        tf = new TargetFinder();
        ac = new AngleCalculator();
        pc = new PositionCalculator();
        Calibration.calibrate();
    }

    /**
     * Runs the positioning.
     */
    public void fire() {
        running = true;
        refreshSnapshots();

        switch (current_boat) {
            case BOAT_1_FRONT:
                min = new int[]{BOAT1_FRONT_COLOR[0], BOAT1_FRONT_COLOR[1], BOAT1_FRONT_COLOR[2], 0};
                max = new int[]{BOAT1_FRONT_COLOR[3], BOAT1_FRONT_COLOR[4], BOAT1_FRONT_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_1_BACK:
                min = new int[]{BOAT1_BACK_COLOR[0], BOAT1_BACK_COLOR[1], BOAT1_BACK_COLOR[2], 0};
                max = new int[]{BOAT1_BACK_COLOR[3], BOAT1_BACK_COLOR[4], BOAT1_BACK_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_2_FRONT:
                min = new int[]{BOAT2_FRONT_COLOR[0], BOAT2_FRONT_COLOR[1], BOAT2_FRONT_COLOR[2], 0};
                max = new int[]{BOAT2_FRONT_COLOR[3], BOAT2_FRONT_COLOR[4], BOAT2_FRONT_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_2_BACK:
                min = new int[]{BOAT2_BACK_COLOR[0], BOAT2_BACK_COLOR[1], BOAT2_BACK_COLOR[2], 0};
                max = new int[]{BOAT2_BACK_COLOR[3], BOAT2_BACK_COLOR[4], BOAT2_BACK_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_3_FRONT:
                min = new int[]{BOAT3_FRONT_COLOR[0], BOAT3_FRONT_COLOR[1], BOAT3_FRONT_COLOR[2], 0};
                max = new int[]{BOAT3_FRONT_COLOR[3], BOAT3_FRONT_COLOR[4], BOAT3_FRONT_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_3_BACK:
                min = new int[]{BOAT3_BACK_COLOR[0], BOAT3_BACK_COLOR[1], BOAT3_BACK_COLOR[2], 0};
                max = new int[]{BOAT3_BACK_COLOR[3], BOAT3_BACK_COLOR[4], BOAT3_BACK_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_4_FRONT:
                min = new int[]{BOAT4_FRONT_COLOR[0], BOAT4_FRONT_COLOR[1], BOAT4_FRONT_COLOR[2], 0};
                max = new int[]{BOAT4_FRONT_COLOR[3], BOAT4_FRONT_COLOR[4], BOAT4_FRONT_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case BOAT_4_BACK:
                min = new int[]{BOAT4_BACK_COLOR[0], BOAT4_BACK_COLOR[1], BOAT4_BACK_COLOR[2], 0};
                max = new int[]{BOAT4_BACK_COLOR[3], BOAT4_BACK_COLOR[4], BOAT4_BACK_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
        }
        Point picpoint1 = tf.detectPosition(PATH + CAM1_PIC_ID);
        Point picpoint2 = tf.detectPosition(PATH + CAM2_PIC_ID);
        Point picpoint3 = tf.detectPosition(PATH + CAM3_PIC_ID);
        Point picpoint4 = tf.detectPosition(PATH + CAM4_PIC_ID);
        Point picpoint5 = tf.detectPosition(PATH + CAM5_PIC_ID);
        Point picpoint6 = tf.detectPosition(PATH + CAM6_PIC_ID);
        Point picpoint7 = tf.detectPosition(PATH + CAM7_PIC_ID);
        Point picpoint8 = tf.detectPosition(PATH + CAM8_PIC_ID);

//        tf.loadAndSave(PATH + CAM1_PIC_ID);
//        tf.loadAndSave(PATH + CAM2_PIC_ID);
//        tf.loadAndSave(PATH + CAM3_PIC_ID);
//        tf.loadAndSave(PATH + CAM4_PIC_ID);
//        tf.loadAndSave(PATH + CAM5_PIC_ID);
//        tf.loadAndSave(PATH + CAM6_PIC_ID);
//        tf.loadAndSave(PATH + CAM7_PIC_ID);
//        tf.loadAndSave(PATH + CAM8_PIC_ID);


        double cam1_angle = ac.update(picpoint1);
        double cam2_angle = ac.update(picpoint2);
        double cam3_angle = ac.update(picpoint3);
        double cam4_angle = ac.update(picpoint4);
        double cam5_angle = ac.update(picpoint5);
        double cam6_angle = ac.update(picpoint6);
        double cam7_angle = ac.update(picpoint7);
        double cam8_angle = ac.update(picpoint8);

        current_point = pc.calcPosition(cam1_angle, cam2_angle, cam3_angle, cam4_angle, cam5_angle, cam6_angle, cam7_angle, cam8_angle);
        running = false;
    }

    /**
     * Refreshes the snapshots of the cameras.
     */
    public void refreshSnapshots() {
        try {
            //Create URL's
            URL url_cam1 = new URL(cam1_snapshot);
            URL url_cam2 = new URL(cam2_snapshot);
            URL url_cam3 = new URL(cam3_snapshot);
            URL url_cam4 = new URL(cam4_snapshot);
            URL url_cam5 = new URL(cam5_snapshot);
            URL url_cam6 = new URL(cam6_snapshot);
            URL url_cam7 = new URL(cam7_snapshot);
            URL url_cam8 = new URL(cam8_snapshot);

            //Create Images of the URL's
            BufferedImage im1 = ImageIO.read(url_cam1);
            BufferedImage im2 = ImageIO.read(url_cam2);
            BufferedImage im3 = ImageIO.read(url_cam3);
            BufferedImage im4 = ImageIO.read(url_cam4);
            BufferedImage im5 = ImageIO.read(url_cam5);
            BufferedImage im6 = ImageIO.read(url_cam6);
            BufferedImage im7 = ImageIO.read(url_cam7);
            BufferedImage im8 = ImageIO.read(url_cam8);

            //Put images in folder so TargetFinder can read them
            File out1 = new File(PATH + CAM1_PIC_ID);
            ImageIO.write(im1, "jpg", out1);
            File out2 = new File(PATH + CAM2_PIC_ID);
            ImageIO.write(im2, "jpg", out2);
            File out3 = new File(PATH + CAM3_PIC_ID);
            ImageIO.write(im3, "jpg", out3);
            File out4 = new File(PATH + CAM4_PIC_ID);
            ImageIO.write(im4, "jpg", out4);
            File out5 = new File(PATH + CAM5_PIC_ID);
            ImageIO.write(im5, "jpg", out5);
            File out6 = new File(PATH + CAM6_PIC_ID);
            ImageIO.write(im6, "jpg", out6);
            File out7 = new File(PATH + CAM7_PIC_ID);
            ImageIO.write(im7, "jpg", out7);
            File out8 = new File(PATH + CAM8_PIC_ID);
            ImageIO.write(im8, "jpg", out8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns whether the puc is running.
     *
     * @return the boolean running.
     */
    public boolean isRunning() {
        return running;
    }
}
