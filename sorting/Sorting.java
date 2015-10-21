package algos;
/**
 * 
 * @author Vishal Gaurav , vishal.gaurav@hotmail.com
 * This file contains implementation for few sorting algorithms
 * sorting using generic objects 
 */
public class Sorting<T extends Comparable<T>> {

    public static void main(String[] args) {
        boolean isSorted = false;
        Integer[] arrayToBeSorted = getTestArray();
        new Sorting<Integer>().SelectionSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Selection sorting success = " + isSorted);
        isSorted = false;
        arrayToBeSorted = getTestArray();
        new Sorting<Integer>().BubbleSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Bubble sorting success = " + isSorted);
        isSorted = false;
        arrayToBeSorted = getTestArray();
        new Sorting<Integer>().InsertionSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Insertion sorting success = " + isSorted);
         
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
         for (int count = 0; count < arrayToBeSorted.length - 1; count++) {
               minIndex = count ;
            for (int countInner = count; countInner < arrayToBeSorted.length; countInner++) {
                if(arrayToBeSorted[countInner].compareTo(arrayToBeSorted[minIndex]) <= 0 ){
                    minIndex = countInner ;
                }
            }
            swapArrayItems(arrayToBeSorted, count, minIndex);
        }
    }
    /**
     * this method will sort an array by BubbleSort algorithm
     * @param arrayToBeSorted
     * @param length
     */
    public void BubbleSort(T[] arrayToBeSorted, int length ){
        boolean isSortingNeeded = false ;
        for (int count = 0; count < arrayToBeSorted.length; count++) {
           isSortingNeeded = false ;
           for (int countInner = 0; countInner < arrayToBeSorted.length - 1 - count; countInner++) {
               if(arrayToBeSorted[countInner].compareTo(arrayToBeSorted[countInner + 1]) > 0 ){
                  swapArrayItems(arrayToBeSorted, countInner, countInner + 1);
                   isSortingNeeded = true ;
               }
           }
           if(!isSortingNeeded){
               break ; 
           }
       }
    }
    /**
     * helper method to swap array items.
     * @param array in which elements will be swapped.
     * @param swapFrom swapIndex 1
     * @param swapTo swapIndex 2
     */
    private void swapArrayItems(T[] array, int swapFrom , int swapTo){
        T tempValue = array[swapFrom];
        array[swapFrom] = array[swapTo];
        array[swapTo] = tempValue;
    }
    /**
     * this method will sort an array by InsertionSort algorithm
     * @param arrayToBeSorted
     * @param length
     */
    public void InsertionSort(T[] arrayToBeSorted, int length ){
        for (int count = 1; count < arrayToBeSorted.length; count++) {
            while(count - 1 >= 0 && arrayToBeSorted[count].compareTo(arrayToBeSorted[count -1]) < 0){
                swapArrayItems(arrayToBeSorted, count, count - 1);
                count-- ;
            }
        }
    }

}
