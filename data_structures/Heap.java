import java.util.List;
import java.util.Vector;

/**
 * @author Vishal Gaurav
 *
 */
public abstract class Heap<T extends Comparable<T>> {
    
    protected int capacity;
    protected List<T> heap ;
    
    public Heap(int size) {
        this.capacity = size;
        heap = new Vector<>();
    }
    
    public int capacity(){
        return capacity;
    }
    
    protected int getParent(int childIndex){
        return (childIndex - 1) / 2 ;
    }
    
    protected int getLeftChildIndex(int parent){
        return (parent * 2) + 1;
    }
    
    protected int getRightchildIndex(int parent){
        return (parent * 2) + 2;
    }
    
    protected void swap(int from , int to){
        T temp = heap.get(from);
        heap.set(from,heap.get(to));
        heap.set(to,temp);
    }
    /**
     * inserts the element in heap at its proper place.
     * 
     * @param element
     * @return
     */
    public abstract boolean insert(T element);
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return element at the head of the queue
     */
    public abstract T peek();
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return
     */
    public abstract T poll();
    
    /**
     * Returns the number of elements in this collection.
     * @return
     */
    public abstract int size();
    
    /**
     * sends an element from its current to position to upper level
     * @param position from which an element will be shifted to upper levels as per heap rule.
     */
    protected abstract void floatUp(int posoition);
    
    /**
     * sends an element from its current to position to lower level
     * @param position from which an element will be shifted to lower levels as per heap rule.
     */
    protected abstract void floatDown(int posoition);
}
