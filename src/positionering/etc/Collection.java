package positionering.etc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** This class contains sourcecode for an implementation of a collection. 
 *  The collection can only contain PointCollection.
 *
 * @author Dion
 * @see PointCollection.java
 */
public class Collection implements Iterable<PointCollection> {
    
    PointCollection[] col;
    private int size;
    
    /** Creates a Collection object.
     * 
     */
    public Collection(){
        col = new PointCollection[16];
        size = 0;              
    }
    
    /** Adds a PointCollection to the Collection.
     * 
     * @param p_coll The PointCollection to be added.
     */
    public void add(PointCollection p_coll){
        if(size < 16){
        col[size] = p_coll;
        size++;
        }
        /* Else, do nothing. */
    }
    
    /** Returns the PointCollection on the given index.
     * 
     * @param index the index
     * @return the PointCollection on the given index.
     */
    public PointCollection get(int index){
        return col[index];
    }
    
    /** Returns the size of the Collection.
     * 
     * @return the size of the collection.
     */
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "Collection{" + "col=" + col + ", size=" + size + '}';
    }

    @Override
    public Iterator<PointCollection> iterator() {
        return new CollectionIterator();
    }
    
    private class CollectionIterator implements Iterator<PointCollection>{

        private int position = 0;
        
        @Override
        public boolean hasNext() {
            return size < 16;
        }

        @Override
        public PointCollection next() {
            if(hasNext()){
                PointCollection current = col[position];
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
