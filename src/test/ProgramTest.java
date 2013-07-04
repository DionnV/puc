/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import positionering.etc.Point;
import positionering.gui.GUI;
import positionering.puc.puc;

/**
 *
 * @author Dion
 */
public class ProgramTest {

    public static void main(String[] args) {
        Point front;
        Point back;
        puc puctest = new puc();
        puctest.initiateTest();
        GUI gui = new GUI();
        Point[] points = new Point[]{
            new Point(530, 390),
            new Point(530, 405),
            new Point(550, 370),
            new Point(540, 380),
            new Point(580 ,350),
            new Point(570 ,350)
        };

//        Point[] pos_1_front = new Point[]{
//            new Point(), //cam 1
//            new Point(), //cam 2
//            new Point(), //cam 3
//            new Point(), //cam 4
//            new Point(), //cam 5
//            new Point(), //cam 6
//            new Point(), //cam 7
//            new Point()  //cam 8
//        };
//
//        Point[] pos_1_back = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_2_front = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_2_back = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_3_front = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_3_back = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_4_front = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_4_back = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_5_front = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//
//        Point[] pos_5_back = new Point[]{
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point(),
//            new Point()
//        };
//        Point[][] col = new Point[][]{
//            pos_1_front, 
//            pos_1_back, 
//            pos_2_front, 
//            pos_2_back, 
//            pos_3_front, 
//            pos_3_back, 
//            pos_4_front, 
//            pos_4_back,
//            pos_5_front, 
//            pos_5_back
//        };
//Helper.calc(new Point(530, 400));
        while (true) {      
            for(int i = 0; i < points.length; i += 2){
                puctest.runTest(points[i]);
                while(puctest.isRunning()){}
                front = puctest.current_point;
                puctest.runTest(points[i+1]);
                while(puctest.isRunning()){}
                back = puctest.current_point;
                gui.locateBoat(front, back, 1);
                try{
                    Thread.sleep(500);                  
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
