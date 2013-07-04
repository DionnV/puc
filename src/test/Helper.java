/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import positionering.etc.Point;

/**
 *
 * @author Dion
 */
public class Helper {

    public static void calc(Point p) {
        
        //for cam 1 and 2
        double angle = 180 * (Math.atan2((double) p.y, (double) p.x)) / Math.PI;
        if (angle < 30) {
            angle *= 3;
            System.out.println("cam1 point(" + (320 + (100 * Math.cos(angle))) + "," + 100 * Math.sin(angle) + ")");
            System.out.println("cam2 point(0,0)");
        } else if (angle > 60) {
            angle -= 30;
            angle *= 3;
            System.out.println("cam1 point(0,0)");
            System.out.println("cam2 point(" + (320 + 100 * Math.cos(angle)) + "," + (100 * Math.sin(angle)) + ")");

        } else {
            angle *= 3;
            System.out.println("cam1 point(" + (320 + (100 * Math.cos(angle))) + "," + 100 * Math.sin(angle) + ")");
            angle -= 10;
            System.out.println("cam2 point(" + (320 + (100 * Math.cos(angle))) + "," + 100 * Math.sin(angle) + ")");
        }

        //for cam 3 and 4
        angle = 180 * (Math.atan2((double) p.y, (double) 1060 - p.x)) / Math.PI;
        if (angle < 30) {
            angle *= 3;
            System.out.println("cam1 point(" + (320 + (100 * Math.cos(angle))) + "," + (100 * Math.sin(angle)) + ")");
            System.out.println("cam2 point(0,0)");
        } else if (angle > 60) {
            angle -= 30;
            angle *= 3;
            System.out.println("cam1 point(0,0)");
            System.out.println("cam2 point(" + (320 + 100 * Math.cos(angle)) + "," + (100 * Math.sin(angle)) + ")");

        } else {
            angle *= 3;
            System.out.println("cam1 point(" + (320 + (100 * Math.cos(angle))) + "," + (100 * Math.sin(angle)) + ")");
            angle -= 10;
            System.out.println("cam2 point(" + (320 + (100 * Math.cos(angle))) + "," + (100 * Math.sin(angle)) + ")");
        }
    }
}
