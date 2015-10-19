package algos;
/**
 * 
 * @author Vishal Gaurav , vishal.gaurav@hotmail.com
 * This file contains implementation for few sorting algorithms
 * sorting using generic objects 
 */
public class Sorting<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] arrayToBeSorted = getTestArray();
        new Sorting<Integer>().SelectionSort(arrayToBeSorted, arrayToBeSorted.length);
        System.out.println(arrayToBeSorted);
        boolean isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("sorting success = " + isSorted);
    }
    
    /**
     * method to verify sorting of an array.
     * @param arrayToBeSorted
     * @return true is array passed is sorted.
     */
    private static boolean isArraySorted(Integer[] arrayToBeSorted) {
        boolean result = true;
        for (int i = 0; i < arrayToBeSorted.length-1; i++) {
            if(arrayToBeSorted[i].compareTo(arrayToBeSorted[i+1]) > 0){
                result = false;
                break;
            }
        }
        return result;
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
        int minIndex ;
         for (int count = 0; count < arrayToBeSorted.length; count++) {
               minIndex = count ;
            for (int countInner = count; countInner < arrayToBeSorted.length; countInner++) {
                if(arrayToBeSorted[countInner].compareTo(arrayToBeSorted[minIndex]) <= 0 ){
                    minIndex = countInner ;
                }
            }
            T tempValue = arrayToBeSorted[count];
            arrayToBeSorted[count] = arrayToBeSorted[minIndex];
            arrayToBeSorted[minIndex] = tempValue;
        }
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
