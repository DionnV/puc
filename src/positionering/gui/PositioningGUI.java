package positionering.gui;

import positionering.etc.Point;
import positionering.heading.Heading;
import javax.swing.JOptionPane;

/**
 * @author Bart Simons
 */
public class PositioningGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI a = new GUI();
 //       for (int i = 0; i < 30; i++) {
//            JOptionPane.showInputDialog("index boot? bigproject");
//            int x = Integer.parseInt(JOptionPane.showInputDialog("X-positie?"));
//            int y = Integer.parseInt(JOptionPane.showInputDialog("Y-positie?"));
            Point boot = new Point(100, 100);
            double H = Heading.calc(new Point(0,0), new Point(10,0));
            JOptionPane.showMessageDialog(a, H);
            a.locateBoat(boot, H,1);
            
//        }

    }
}
