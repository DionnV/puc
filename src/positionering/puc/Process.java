package positionering.puc;

import positionering.gui.*;

/**
 *
 * @author Dion
 */
public class Process {

    public static void main(String[] args) {
        puc pucproc = new puc();
        GUI a = new GUI();
        while (true) {
            pucproc.run();
            while (pucproc.isRunning()) {
            }
            a.locateBoat(pucproc.current_point, 1);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
