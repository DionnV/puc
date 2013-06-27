package positionering.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import positionering.etc.Point;

/**
 *
 * @author Bart Simons
 */
public class GUI extends Canvas {

    private int startBakX = 90;
    private int startBakY = 5;
    private JFrame aFrame = new JFrame("Positiebepaling");
    private Rectangle boat = new Rectangle();
    private Boot[] boats = new Boot[4];

    /**
     * Een lege GUI bouwen, zonder deze zichtbaar te maken.
     */
    public GUI() {
        build();
    }
    /**
     * Een GUI bouwen, die teven gevuld wordt met de meegegeven boot. De GUI
     * is direct zichtbaar
     * @param boat de locatie van de te tekenen boot
     * @param bootnr de index van de te tekenen boot
     */
    public GUI(Point boat, double heading, int bootnr) {
        build();
        locateBoat(boat, heading, bootnr);
    }
    /**
     * Een frame creeeren met vaste instellingen.
     */
    private void build() {

        aFrame.setSize(1280, 850);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setResizable(true);
        aFrame.add(this);
    }
    /**
     * Een boot tekenen in het vlak.
     * @param boat de cooordinaten van de te tekenen boot.
     * @param bootnr de index van de te tekenen boot.
     */
    public void locateBoat(Point boat, double heading, int bootnr) {
        bootnr = bootnr -1;
        boat.x = (boat.x + startBakX);
        boat.y = (boat.y + startBakY);
        if(boats[bootnr] == null){
            boats[bootnr] = new Boot(boat.x, boat.y, heading, bootnr);
        } else {
            boats[bootnr].updateBoot(boat.x, boat.y, heading);
        }
        if (aFrame.isVisible()) {
            repaint();
        } else {
            aFrame.setVisible(true);
        }

    }

//    @Override
//    public void update(Graphics g){
//        paint(g);
//    }
    /**
     * Het tekenen van de achtergrond en boten gebeurd in deze methode.
     * Het hoe en waarom van deze methode is in duisternis gehuld.
     * @param g Graphics waarvan ik niet weet hoe t werkt of waarom?
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(startBakX, startBakY, 1060, 795);
        for (int i = 0; i < boats.length; i++) {
            //int last = 0;
            if (boats[i] != null) {
                Rectangle test = new Rectangle(boats[i].getX(), boats[i].getY(), boats[i].getWidth(),boats[i].getHeigth());
                g2d.setColor(Color.red);
                g2d.rotate(Math.toRadians(boats[i].getHeading()), boats[i].getX()+(boats[i].getWidth()/2), boats[i].getY()+(boats[i].getHeigth()/2));
//                g2d.draw(boats[i].rBoat);              
                g2d.fill(test);
                g2d.setColor(Color.BLACK);
                g2d.drawString("^", (float)test.getCenterX(), (float)test.getCenterY());
         
            }

        }
    }
}