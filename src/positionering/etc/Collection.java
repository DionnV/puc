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
public class Collection implements Iterable<PointCollection> {
    
    PointCollection[] col;
    private int size;
    
    public Collection(){
        col = new PointCollection[16];
        size = 0;              
    }
    
    public void add(PointCollection p_coll){
        if(size < 16){
        col[size] = p_coll;
        size++;
        }
        /* Else, do nothing. */
    }
    
    public PointCollection get(int index){
        return col[index];
    }
    
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
