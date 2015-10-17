package algos;
/**
 * 
 * @author Vishal Gaurav , vishal.gaurav@hotmail.com
 * This file contains implementation for few sorting algorithms
 *
 */
public class Sorting<T> {

    public static void main(String[] args) {
        Integer[] arrayToBeSorted = getTestArray(); 
    }
    
    
    private static Integer[] getTestArray() {
        Integer[] testArray = new Integer[35];
        for (int i = 0; i < testArray.length; i++) {
            testArray[testArray.length - i - 1] = i ;
        }
        return testArray;
    }


    /**
     * this method will sort an array by SelectionSort algorithm
     * @param arrayToBeSorted
     * @param length
     */
    public void SelectionSort(T[] arrayToBeSorted, int length ){
        
    }
    /**
     * this method will sort an array by BubbleSort algorithm
     * @param arrayToBeSorted
     * @param length
     */
    public void BubbleSort(T[] arrayToBeSorted, int length ){
        
    }
    /**
     * this method will sort an array by InsertionSort algorithm
     * @param arrayToBeSorted
     * @param length
     */
    public void InsertionSort(T[] arrayToBeSorted, int length ){
        
    }

}
