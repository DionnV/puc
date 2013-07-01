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
public class Process {

    public static void main(String[] args) {
        Point front;
        Point back;
        Point diff;
        puc pucproc = new puc();
        GUI a = new GUI();
        while (true) {
            for (BoatState bs : BoatState.values()) {
                pucproc.current_boat = bs;
                pucproc.run();
                while (pucproc.isRunning()) {
                }
                front = pucproc.current_point;
                System.out.println("Got front; " + front.toString());
                back = pucproc.current_point;
                System.out.println("Got back; " + back.toString());
                diff = new Point((front.x + back.x) / 2, (front.y + back.y) / 2);
                System.out.println("Mean point; " + diff.toString());
                a.locateBoat(diff, Heading.calc(front, back), 1);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
