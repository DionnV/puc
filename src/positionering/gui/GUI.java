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
    private Boot[] boats = new Boot[4];

    /**
     * Build empty GUI without making it visible.
     * Not recommended!
     */
    public GUI() {
        build();
    }
    /**
     * Builds a visible GUI, in which the given boat is immediately drawn. 
     * @param boat the position the boat that has to be drawn.
     * @param bootnr the index of the boat that has to be drawn.
     * @param heading the heading of the boat that has to be drawn.
     */
    public GUI(Point boat, double heading, int bootnr) {
        build();
       // locateBoat(boat, heading, bootnr);
    }
    /**
     * Create a GUI with set properties.
     * To change GUI settings, change this method.
     */
    private void build() {

        aFrame.setSize(1280, 850);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setResizable(true);
        aFrame.add(this);
    }
    /**
     * Draws a boat at a given location with specified heading.
     * This function automatically detects if the boat has been previously drawn
     * so no extra methods are needed to update a boat.
     * @param boat the (new) position of the boat
     * @param bootnr the index of the boat.
     * @param heading the (new) heading of the boat.
     */
    public void locateBoat(Point front, Point back, int bootnr) {
        bootnr = bootnr -1;
        front.x = (front.x + startBakX);
        front.y = (front.y + startBakY);
        back.x = (back.x + startBakX);
        back.y = (front.y + startBakY);
        if(boats[bootnr] == null){
            boats[bootnr] = new Boot(front, back, bootnr);
        } else {
            boats[bootnr].updateBoot(front, back);
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
     * Draws the complete GUI.
     * @param g Graphics.
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(startBakX, startBakY, 1060, 795);
        for (int i = 0; i < boats.length; i++) {
            //int last = 0;
            if (boats[i] != null) {
                Graphics2D boot = (Graphics2D) g;
                boot.setColor(boats[i].getKleur());
//                boot.rotate(Math.toRadians(boats[i].getHeading()), boats[i].getX()+(boats[i].getWidth()/2), boats[i].getY()+(boats[i].getHeigth()/2));
                boot.fill(boats[i].Boat);
         

            }

        }
    }
}
