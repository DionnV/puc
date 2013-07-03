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
        int bootnr = 1;
        for(int i = 0; i < 200;i = i+10){
            int b11 = Integer.parseInt(JOptionPane.showInputDialog("x1"));
            int b12 = Integer.parseInt(JOptionPane.showInputDialog("y1"));
            int b21 = Integer.parseInt(JOptionPane.showInputDialog("x2"));
            int b22 = Integer.parseInt(JOptionPane.showInputDialog("y2"));
            Point front = new Point(b11,b12);
            Point back = new Point(b21,b22);
            a.locateBoat(front, back, bootnr);

        }
    }
}
