package positionering.gui;

import javax.swing.JOptionPane;
import positionering.etc.Point;
import positionering.heading.Heading;

/**
 * @author Bart Simons
 */
public class PositioningGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI a = new GUI();
        int bootnr =1;
        Point front = new Point(100,90);
        Point back = new Point(101,91);
        a.locateBoat(front, back, bootnr);    
    }
}
