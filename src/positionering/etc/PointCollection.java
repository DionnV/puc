package positionering.etc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class contains sourcecode to create a PointCollection.
 *
 * @author Dion
 */
public class PointCollection implements Iterable<Point> {

    private int size;
    private Point[] p_coll;

    /**
     * Creates a PointCollection object.
     */
    public PointCollection() {
        size = 0;
        p_coll = new Point[16];
    }

    /**
     * Adds a Point to the PointCollection.
     *
     * @param p The Point to be added.
     */
    public void add(Point p) {
        if (size < 16) {
            p_coll[size] = p;
            size++;
        }
        /*
         * Else, do nothing
         */
    }

    public void remove(int i) {
        Point[] temp = new Point[p_coll.length -1];
        for(int j=0;j<i;j++){
        temp[j] = this.p_coll[j];
        }
        for(int j=i+1;j<p_coll.length;j++){
        temp[j-1] = this.p_coll[j];
        }
        this.p_coll = temp;
    }

    /**
     * Returns the Point on the given index.
     *
     * @param index the index
     * @return the Point on the given index.
     */
    public Point get(int index) {
        return p_coll[index];
    }

    /**
     * Returns the size of the Collection.
     *
     * @return the size of the collection.
     */
    public int size() {
        return size;
    }

    /**
     * Filters all Point objects out of the PointCollection which are not in the
     * given range.
     *
     * @param index The main Point.
     * @param range The range.
     * @return A PointCollection object containing all filtered Point objects.
     */
    public PointCollection filter(int index, int range) {
        PointCollection filtered = new PointCollection();
        filtered.add(this.get(index));
        for (Point p : this.p_coll) {
            if (filtered.get(1).x <= p.x + range && filtered.get(1).x >= p.x - range) {
                if (filtered.get(1).y <= p.y + range && filtered.get(1).y >= p.y - range) {
                    filtered.add(p);
                }
            }
        }
        return filtered;
    }

    @Override
    public Iterator<Point> iterator() {
        return new PointIterator();
    }

    private class PointIterator implements Iterator<Point> {

        private int position = 0;

        @Override
        public boolean hasNext() {
            return size < 16;
        }

        @Override
        public Point next() {
            if (hasNext()) {
                Point current = p_coll[position];
                position++;
                return current;
            } else {
                throw new NoSuchElementException();
            }

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
