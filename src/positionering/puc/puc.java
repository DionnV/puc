package positionering.puc;

import positionering.etc.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import positionering.javacv.TargetFinder;
import positionering.math.AngleCalculator;
import positionering.math.PositionCalculator;

/**
 *
 * @author Dion
 */
public class puc {

    private static final String CAM1_IP = "http://192.168.0.11";
    private static final String CAM2_IP = "http://192.168.0.12";
    private static final String CAM3_IP = "http://192.168.0.13";
    private static final String CAM4_IP = "http://192.168.0.14";    
    private static final String CAM5_IP = "http://192.168.0.15";
    private static final String CAM6_IP = "http://192.168.0.16";
    private static final String CAM7_IP = "http://192.168.0.17";
    private static final String CAM8_IP = "http://192.168.0.18";  
    private static final String PORT = ":81";
    
    private static final String SNAPSHOT = "/snapshot.jpg";
   
    private static final String USERNAME = "admin";
    private static final String PASS = "admin";    
    private static final String AUTH = "?user=" + USERNAME + "&pwd=" + PASS;
    
    private static final String PATH = "C:/Imtech/Posipics/";
    private static final String CAM1_PIC_ID = "cam1id.jpg";
    private static final String CAM2_PIC_ID = "cam2id.jpg";
    private static final String CAM3_PIC_ID = "cam3id.jpg";
    private static final String CAM4_PIC_ID = "cam4id.jpg";
    private static final String CAM5_PIC_ID = "cam5id.jpg";
    private static final String CAM6_PIC_ID = "cam6id.jpg";
    private static final String CAM7_PIC_ID = "cam7id.jpg";
    private static final String CAM8_PIC_ID = "cam8id.jpg";
    
    private static final int[] BOAT1_COLOR = {30, 120, 0, 255, 255, 70};
    private static final int[] BOAT2_COLOR = {0, 0, 0, 0, 0, 0};
    private static final int[] BOAT3_COLOR = {0, 0, 0, 0, 0, 0};
    private static final int[] BOAT4_COLOR = {0, 0, 0, 0, 0, 0};
    
    public int current_boat = 1;
    public Point current_point;
    
    private String cam1_snapshot = CAM1_IP + PORT + SNAPSHOT + AUTH;
    private String cam2_snapshot = CAM2_IP + PORT + SNAPSHOT + AUTH;
    private String cam3_snapshot = CAM3_IP + PORT + SNAPSHOT + AUTH;
    private String cam4_snapshot = CAM4_IP + PORT + SNAPSHOT + AUTH;
    private String cam5_snapshot = CAM5_IP + PORT + SNAPSHOT + AUTH;
    private String cam6_snapshot = CAM6_IP + PORT + SNAPSHOT + AUTH;
    private String cam7_snapshot = CAM7_IP + PORT + SNAPSHOT + AUTH;
    private String cam8_snapshot = CAM8_IP + PORT + SNAPSHOT + AUTH;
    
    TargetFinder tf;
    AngleCalculator ac;
    PositionCalculator pc;
    int[] min;
    int[] max;
    private boolean running = false;

    public puc() {
        tf = new TargetFinder();
        ac = new AngleCalculator();
        pc = new PositionCalculator();
    }

    public void run() {
        running = true;
        refreshSnapshots();

        switch (current_boat) {
            case 1:
                min = new int[]{BOAT1_COLOR[0], BOAT1_COLOR[1], BOAT1_COLOR[2], 0};
                max = new int[]{BOAT1_COLOR[3], BOAT1_COLOR[4], BOAT1_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case 2:
                min = new int[]{BOAT2_COLOR[0], BOAT2_COLOR[1], BOAT2_COLOR[2], 0};
                max = new int[]{BOAT2_COLOR[3], BOAT2_COLOR[4], BOAT2_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case 3:
                min = new int[]{BOAT3_COLOR[0], BOAT3_COLOR[1], BOAT3_COLOR[2], 0};
                max = new int[]{BOAT3_COLOR[3], BOAT3_COLOR[4], BOAT3_COLOR[5], 0};
                tf.setTargetColor(min, max);
                break;
            case 4:
                min = new int[]{BOAT4_COLOR[0], BOAT4_COLOR[1], BOAT4_COLOR[2], 0};
                max = new int[]{BOAT4_COLOR[3], BOAT4_COLOR[4], BOAT4_COLOR[5], 0};
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

    public void refreshSnapshots() {
        try {
            //Create URL's
            URL url_cam1 = new URL(cam1_snapshot);
            URL url_cam2 = new URL(cam2_snapshot);
            URL url_cam3 = new URL(cam3_snapshot);
            URL url_cam4 = new URL(cam4_snapshot);

            //Create Images of the URL's
            BufferedImage im1 = ImageIO.read(url_cam1);
            BufferedImage im2 = ImageIO.read(url_cam2);
            BufferedImage im3 = ImageIO.read(url_cam3);
            BufferedImage im4 = ImageIO.read(url_cam4);

            //Put images in folder so TargetFinder can read them
            File out1 = new File(PATH + CAM1_PIC_ID);
            ImageIO.write(im1, "jpg", out1);
            File out2 = new File(PATH + CAM2_PIC_ID);
            ImageIO.write(im2, "jpg", out2);
            File out3 = new File(PATH + CAM3_PIC_ID);
            ImageIO.write(im3, "jpg", out3);
            File out4 = new File(PATH + CAM4_PIC_ID);
            ImageIO.write(im4, "jpg", out4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isRunning(){
        return running;
    }
}
