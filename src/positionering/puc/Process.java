package positionering.puc;

import positionering.etc.BoatState;
import positionering.etc.Point;
import positionering.gui.GUI;
import positionering.heading.Heading;

/**
 * This class contains the main method.
 *
 * @author Dion
 */
public class Process implements Runnable {

    @Override
    public void run() {
        Point front = new Point(0, 0);
        Point back = new Point(0, 0);
        Point diff;
        puc pucproc = new puc();
        GUI gui = new GUI();

        pucproc.initiate();

        while (true) {
            for (BoatState bs : BoatState.values()) {
                pucproc.current_boat = bs;
                pucproc.fire();
                while (pucproc.isRunning()) {
                    //Do nothing while its running.
                }
                if (bs.getPos() % 2 != 0) {
                    front = pucproc.current_point;
                    System.out.println("Got front; " + front.toString());
                    break;
                } else {
                    back = pucproc.current_point;
                    System.out.println("Got back; " + back.toString());
                }
                gui.locateBoat(front, back, bs.getId());
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
