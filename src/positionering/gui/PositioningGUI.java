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
        for (int i = 0; i < 30; i++) {
            int btnr = Integer.parseInt(JOptionPane.showInputDialog("index boot? bigproject"));
            int x = Integer.parseInt(JOptionPane.showInputDialog("X-positie?"));
            int y = Integer.parseInt(JOptionPane.showInputDialog("Y-positie?"));
            double H = 45.0;        
            Point boot = new Point(x, y);
        //    a.locateBoat(boot, H,btnr);
 //       for (int i = 0; i < 30; i++) {
//            JOptionPane.showInputDialog("index boot? bigproject");
//            int x = Integer.parseInt(JOptionPane.showInputDialog("X-positie?"));
//            int y = Integer.parseInt(JOptionPane.showInputDialog("Y-positie?"));
       //     a.locateBoat(boot, H,1);
            
        }

    }
}
