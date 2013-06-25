package positionering.gui;

import java.awt.Color;
//import positionering.etc.Point;
import positionering.etc.Point;

/**
 * @author Bart Simons
 */
public class Boot {
    //FIELDS
    private int x;
    private int y;
    private int width = 20;
    private int heigth = 50;
    private int index;
    private Color kleur;
    private int[] pastX = new int[31];
    private int[] pastY = new int[31];
    private int lastPast;
    
    //CONSTRUCTORS
    /**
     *  Lege constructor.
     */
    public Boot(){
        
    }
    
    /**
     * Constructor die direct een gevulde boot aanmaakt.
     * @param x de x-coordinaat van de te maken boot.
     * @param y de y-coordinaat van de te maken boot.
     * @param i de index van de te maken boot. Index bepaalt de kleur.
     */
    public Boot(int x, int y, int i){
        setX(x);
        setY(y);
        setIndex(i);
        setKleur();
        lastPast = 0;
        pastX[lastPast] = x;
        pastY[lastPast] = y;
    }
    
    public void updateBoot(int x, int y){
        if(lastPast < 30){
            lastPast++;
            pastX[lastPast] = getX();
            pastY[lastPast] = getY();
            setX(x);
            setY(y);
        } else{
            lastPast = 0;
            pastX[lastPast] = x;
            pastY[lastPast] = y;
            setX(x);
            setY(y);
        }
    }

    /**
     * @return de x-coordinaten
     */
    public int getX() {
        return x;
    }

    /**
     * @param x de in te stellen x-coordinaat
     */
    public void setX(int x) {
        x = x-(width/2);
        this.x = x;
    }

    /**
     * @return de y-coordinaten
     */
    public int getY() {
        return y;
    }

    /**
     * @param y de in te stellen y-coordinaat
     */
    public void setY(int y) {
        y = y-(heigth/2);
        this.y = y;
    }

    /**
     * @return de breedte van de te tekenen boot.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return de hoogte van de te tekenen boot.
     */
    public int getHeigth() {
        return heigth;
    }

    /**
     * @return de index van de boot
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index de index van de boot
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return de kleur
     */
    public Color getKleur() {
        return kleur;
    }
    
    public Point getPastPosition(int i){
        return new Point(pastX[i],pastY[i]);
    }

    /**
     * Kleur van boot bepalen aan de hand van Indexnummer.
     */
    public void setKleur() {
        if(index==0){
            kleur = Color.GREEN;
        }else if(index==1){
           kleur = Color.YELLOW;
        }else if(index==2){
           kleur = Color.ORANGE;
        }else{
           kleur = Color.BLACK; 
        }
    }
    
    
}
