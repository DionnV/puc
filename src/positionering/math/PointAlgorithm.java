/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package positionering.math;

import positionering.etc.Collection;
import positionering.etc.Point;
import positionering.etc.PointCollection;

/**
 *
 * @author Dion
 */
public class PointAlgorithm {
    
    PointCollection p_coll;
    
    public PointAlgorithm(PointCollection p_coll){
        this.p_coll = p_coll;
    }
    
    public Point getAverage(PointCollection p_c){
        int cum_x = 0;
        int cum_y = 0;
        
        for(Point p : p_c){
            cum_x += p.x;
            cum_y += p.y;
        }
        
        int dx = (int) cum_x/p_c.size();
        int dy = (int) cum_y/p_c.size();
        
        return new Point(dx, dy);
    }
    
    public Point process(){
        PointCollection max = new PointCollection();
        Collection col = new Collection();
        
        for(int i = 0; i < p_coll.size(); i++){
            col.add(p_coll.filter(i, 100));
        }
        
        for(PointCollection p_c : col){
            if(p_c.size() >= max.size()){
                max = p_c;
            }
        }
        return getAverage(max);
    }
    
    
}
