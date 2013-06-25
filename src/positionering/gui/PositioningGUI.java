package positionering.gui;

import positionering.etc.Point;
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
        for (int i = 0; i < 30; i++) {
            int index = Integer.parseInt(JOptionPane.showInputDialog("index boot? bigproject"));
            int x = Integer.parseInt(JOptionPane.showInputDialog("X-positie?"));
            int y = Integer.parseInt(JOptionPane.showInputDialog("Y-positie?"));
            Point boot = new Point(x, y);
            a.locateBoat(boot, index);
        }

    }
}
