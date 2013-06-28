package positionering.math;

import positionering.etc.Collection;
import positionering.etc.Point;
import positionering.etc.PointCollection;

/**
 * This class contains sourcecode which will find the best Point for the
 * PositionCalculator.
 *
 * @author Dion
 */
public class PointAlgorithm {

    PointCollection p_coll;

    /**
     * Creates a PointAlgorithm object.
     *
     * @param p_coll the PointCollection which has to be filtered.
     */
    public PointAlgorithm(PointCollection p_coll) {
        this.p_coll = p_coll;
    }

    /**
     * Calculates the average of all x- and y-coordinates in the given
     * PointCollection.
     *
     * @param p_c the given PointCollection.
     * @return a Point object containing the average x- and y-coordinates.
     */
    public Point getAverage(PointCollection p_c) {
        int cum_x = 0;
        int cum_y = 0;

        for (Point p : p_c) {
            cum_x += p.x;
            cum_y += p.y;
        }

        int dx = (int) cum_x / p_c.size();
        int dy = (int) cum_y / p_c.size();

        return new Point(dx, dy);
    }

    /**
     * Starts the algorithm. The algorithm will filter all PointCollections and
     * will then return the getAverage()-method outcome of the PointCollection
     * containing the most Points.
     *
     * @return a point containing the outcome of the getAverage()-method.
     * @see PointCollection.filter().
     */
    public Point process() {
        PointCollection temp_coll = this.p_coll;
        Point p_final = new Point(0, 0);
        for (int i = 0; i < 4; i++) {
            Point p1 = getAverage(temp_coll);
            double[] distance = new double[temp_coll.size()];
            for (int j = 0; j < temp_coll.size(); j++) {
                Point p_temp = temp_coll.get(j);
                distance[j] = Math.abs(Math.sqrt((Math.pow((p_temp.y - p1.y), 2)) + (Math.pow((p_temp.x - p1.x), 2))));
            }
            double d_temp = 0;
            int index = 0;
            for (int m = 0; m < distance.length; m++) {
                if (distance[m] > d_temp) {
                    d_temp = distance[m];
                    index = m;
                }
            }
            temp_coll.remove(index);

        }
        return p_final;
    }

    public Point process2() {
        PointCollection max = new PointCollection();
        Collection col = new Collection();

        for (int i = 0; i < p_coll.size(); i++) {
            col.add(p_coll.filter(i, 100));
        }

        for (PointCollection p_c : col) {
            if (p_c.size() >= max.size()) {
                max = p_c;
            }
        }
        return getAverage(max);
    }
}
