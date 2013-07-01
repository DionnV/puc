/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
            for(int x = 0; x < buf.getWidth(); x++){
                for(int y = 0; y < buf.getHeight(); y++){
                    int rgb = buf.getRGB(x, y);
                    int red = rgb & 0xFF0000;
                    int green = rgb & 0x00FF00;
                    int blue = rgb & 0x0000FF;
                    cred[red] += 1;
                    cgreen[green] += 1;
                    cblue[blue] += 1;
                }
            }
            filtered = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void printFilterData(){
        if(filtered){
            System.out.println("Red:");
            for(int i = 0; i < cred.length; i++){
                if(cred[i] != 0)
                System.out.println(i + " " + cred[i]);
            }
            System.out.println("Green:");
            for(int i = 0; i < cgreen.length; i++){
                if(cgreen[i] != 0)
                System.out.println(i + " " + cgreen[i]);
            }
            System.out.println("Blue:");
            for(int i = 0; i < cblue.length; i++){
                if(cblue[i] != 0)
                System.out.println(i + " " + cblue[i]);
            }          
        }
    }
}
