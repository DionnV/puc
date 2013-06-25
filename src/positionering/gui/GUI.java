package positionering.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import positionering.etc.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;

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
    public GUI(Point boat, int bootnr) {
        build();
        locateBoat(boat, bootnr);
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
    public void locateBoat(Point boat, int bootnr) {
        bootnr = bootnr -1;
        boat.x = (boat.x + startBakX);
        boat.y = (boat.y + startBakY);
        if(boats[bootnr] == null){
            boats[bootnr] = new Boot(boat.x, boat.y, bootnr);
        } else {
            boats[bootnr].updateBoot(boat.x, boat.y);
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
        g.setColor(Color.BLUE);
        g.fillRect(startBakX, startBakY, 1060, 795);
        for (int i = 0; i < boats.length; i++) {
            int last = 0;
            if (boats[i] != null) {
                g.setColor(boats[i].getKleur());
                g.fillRect(boats[i].getX(), boats[i].getY(), boats[i].getHeigth(), boats[i].getWidth());
                for(int a = 1; boats[i].getPastPosition(a).x!=0&&a<30; a++){
                    g.drawLine(boats[i].getPastPosition(a).x,boats[i].getPastPosition(a).y,boats[i].getPastPosition((a-1)).x,boats[i].getPastPosition((a-1)).y);
                    last = a;
                }
                if(boats[i].getPastPosition(last).x !=0){
                    g.drawLine(boats[i].getPastPosition(last).x, boats[i].getPastPosition(last).y, boats[i].getX(), boats[i].getY());
                }
            }

        }
    }
}