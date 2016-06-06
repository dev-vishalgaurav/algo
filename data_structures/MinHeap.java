/**
 * @author Vishal Gaurav
 *
 */
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    
    public MinHeap(int capacity) {
        super(capacity);
    }

    @Override
    public synchronized boolean insert(T element) {
        if(heap.size() <= capacity){
            heap.add(element);
            floatUp(heap.size() - 1);
            return true;
        }
        return false;
    }

    @Override
    public T peek() {
        if(heap.size() > 0){
            return heap.get(0);
        }
        return null;
    }

    @Override
    public synchronized T poll() {
        if(heap.size() > 0){
            swap(heap.size() -1 , 0);
            T first = heap.remove(heap.size() -1);
            floatDown(0);
            return first;
        }
        return null;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    protected void floatUp(int childIndex) {
        int parentIndex = getParent(childIndex);
        T parent = heap.get(parentIndex);
        T child = heap.get(childIndex);
        if(child.compareTo(parent) < 0 ){
            swap(parentIndex, childIndex);
            floatUp(parentIndex); //  recursive call
        }
    }

    @Override
    protected void floatDown(int parentIndex) {
        T parent = heap.get(parentIndex);
        int leftIndex = getLeftChildIndex(parentIndex);
        int rightIndex = getRightchildIndex(parentIndex);
        if(leftIndex < heap.size()){
            int minIndex = (rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) ? rightIndex : leftIndex ;
            T minElement = heap.get(minIndex);
            if(minElement.compareTo(parent) < 0){
                swap(parentIndex, minIndex);
                floatDown(minIndex); //  recursive call
            }
        }
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("MinHeap test starts");
    }

}
