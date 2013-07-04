package positionering.puc;

import positionering.etc.BoatState;
import positionering.etc.Point;
import positionering.gui.GUI;
import positionering.heading.Heading;
import positionering.javacv.Calibration;

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
        puc pucproc = new puc();
        GUI gui = new GUI();
        Calibration.calibrate();
        pucproc.initiate();

        while (true) {
//            for (BoatState bs : BoatState.values()) {
//                pucproc.current_boat = bs;
//                pucproc.fire();
//                while (pucproc.isRunning()) {
//                    //Do nothing while its running.
//                }
//                if (bs.getPos() % 2 != 0) {
//                    front = pucproc.current_point;
//                    System.out.println("Got front; " + front.toString());
//                    break;
//                } else {
//                    back = pucproc.current_point;
//                    System.out.println("Got back; " + back.toString());
//                }
//                gui.locateBoat(front, back, bs.getId());
            pucproc.current_boat = BoatState.BOAT_1_FRONT;
            pucproc.fire();
            while (pucproc.isRunning()) {
            }
            front = pucproc.current_point;
            pucproc.current_boat = BoatState.BOAT_1_BACK;
            pucproc.fire();
            while (pucproc.isRunning()) {
            }
            back = pucproc.current_point;
            gui.locateBoat(front, back, 1);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

