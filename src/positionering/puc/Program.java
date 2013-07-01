/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package positionering.puc;

/**
 *
 * @author Dion
 */
public class Program {
    
    public static void main(String[] args){
        Thread t = new Thread(new Process());
        t.start();
    }
    
}
