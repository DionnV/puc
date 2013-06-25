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
