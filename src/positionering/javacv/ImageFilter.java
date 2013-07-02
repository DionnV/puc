
package positionering.javacv;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Dion
 */
public class ImageFilter {

    private static int[] cred = new int[256];
    private static int[] cgreen = new int[256];
    private static int[] cblue = new int[256];
    private static boolean filtered = false;

    public static void filter(String path) {
        try {
            BufferedImage buf = ImageIO.read(new File(path));
            for (int x = 0; x < buf.getWidth(); x++) {
                for (int y = 0; y < buf.getHeight(); y++) {
                    int rgb = buf.getRGB(x, y);
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = (rgb) & 0xFF;
                    cred[red] += 1;
                    cgreen[green] += 1;
                    cblue[blue] += 1;
                }
            }
            filtered = true;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Filename: " + path);
        }
    }

    public static void printFilterData() {
        if (filtered) {
            System.out.println("Red:");
            for (int i = 0; i < cred.length; i++) {
                if (cred[i] != 0) {
                    System.out.println(i + " " + cred[i]);
                }
            }
            System.out.println("Green:");
            for (int i = 0; i < cgreen.length; i++) {
                if (cgreen[i] != 0) {
                    System.out.println(i + " " + cgreen[i]);
                }
            }
            System.out.println("Blue:");
            for (int i = 0; i < cblue.length; i++) {
                if (cblue[i] != 0) {
                    System.out.println(i + " " + cblue[i]);
                }
            }
        }
    }

    public static void getAdvice() {
        if (filtered) {
            //These are defined as [value, index]
            int rmax[] = {0, 0};
            int gmax[] = {0, 0};
            int bmax[] = {0, 0};
            for (int i = 0; i < cred.length; i++) {
                if (cred[i] > rmax[0]) {
                    rmax[0] = cred[i];
                    rmax[1] = i;
                }
            }
            for (int i = 0; i < cgreen.length; i++) {
                if (cgreen[i] > gmax[0]) {
                    gmax[0] = cgreen[i];
                    gmax[1] = i;
                }
            }
            for (int i = 0; i < cblue.length; i++) {
                if (cblue[i] > bmax[0]) {
                    bmax[0] = cblue[i];
                    bmax[1] = i;
                }
            }
            System.out.println("The boundaries should be around;");
            System.out.println("Red: " + (rmax[1] - 10) + " to " + (rmax[1] + 10));
            System.out.println("Green: " + (gmax[1] - 10) + " to " + (gmax[1] + 10));
            System.out.println("Blue: " + (bmax[1] - 10) + " to " + (bmax[1] + 10));
        }
    }

    /**
     * This method will return the advised bounds after filtering the image.
     * Bounds will be the maximum of each color, with an upper bound of max + 10
     * and a lower bound of max - 10.
     *
     * @return an int[] countaining {blue_min, green_min, red_min, blue_max,
     * green_max, red_max}.
     */
    public static int[] getBGRBounds() {
        int[] bounds = new int[6];
        if (filtered) {
            //These are defined as [value, index]
            int rmax[] = {0, 0};
            int gmax[] = {0, 0};
            int bmax[] = {0, 0};
            for (int i = 0; i < 256; i++) {
                if (cred[i] > rmax[0]) {
                    rmax[0] = cred[i];
                    rmax[1] = i;
                }
                if (cgreen[i] > gmax[0]) {
                    gmax[0] = cgreen[i];
                    gmax[1] = i;
                }
                if (cblue[i] > bmax[0]) {
                    bmax[0] = cblue[i];
                    bmax[1] = i;
                }
            }
            bounds[0] = (bmax[1] - 10);
            bounds[1] = (gmax[1] - 10);
            bounds[2] = (rmax[1] - 10);
            bounds[3] = (bmax[1] + 10);
            bounds[4] = (gmax[1] + 10);
            bounds[5] = (rmax[1] + 10);
        }
        return bounds;
    }

    public static void clear() {
        for (int i = 0; i < 256; i++) {
            cred[i] = 0;
            cgreen[i] = 0;
            cblue[i] = 0;
        }
    }
}
