/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package positionering.etc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Dion
 */
public class PointCollection implements Iterable<Point> {

    private int size;
    private Point[] p_coll;

    public PointCollection() {
        size = 0;
        p_coll = new Point[16];
    }

    public void add(Point p) {
        if (size < 16) {
            p_coll[size] = p;
            size++;
        }
        /*
         * Else, do nothing
         */
    }

    public Point get(int index) {
        return p_coll[index];
    }

    public int size() {
        return size;
    }

    /**
     * Filterd alle punten uit de PointCollection die niet in range r van het
     * gegeven punt liggen.
     *
     * @param index Het punt waarover gefiltert moet worden.
     * @param range De range die gebruikt wordt voor het filteren.
     * @return Een PointCollection met de gefilterde punten.
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
