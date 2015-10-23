package algos;
/**
 * 
 * @author Vishal Gaurav , vishal.gaurav@hotmail.com
 * This file contains implementation for few sorting algorithms
 * sorting using generic objects 
 */
public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        boolean isSorted = false;
        Integer[] arrayToBeSorted = getTestArray();
        sorting.SelectionSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Selection sorting success = " + isSorted);
        isSorted = false;
        arrayToBeSorted = getTestArray();
        sorting.BubbleSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Bubble sorting success = " + isSorted);
        isSorted = false;
        arrayToBeSorted = getTestArray();
        sorting.InsertionSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Insertion sorting success = " + isSorted);
//        testMergeSortedArray();
        isSorted = false;
        arrayToBeSorted = getTestArray();
        sorting.MergeSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Merge sorting success = " + isSorted);
        
        isSorted = false;
        arrayToBeSorted = getTestArray();
        sorting.QuickSort(arrayToBeSorted, arrayToBeSorted.length);
        isSorted = isArraySorted(arrayToBeSorted);
        System.out.println("Quick sorting success = " + isSorted);
         
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
    public void SelectionSort(Comparable[] arrayToBeSorted, int length ){
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
    public void BubbleSort(Comparable[] arrayToBeSorted, int length ){
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
    private void swapArrayItems(Comparable[] array, int swapFrom , int swapTo){
        Comparable tempValue = array[swapFrom];
        array[swapFrom] = array[swapTo];
        array[swapTo] = tempValue;
    }
    /**
     * this method will sort an array by InsertionSort algorithm
     * @param arrayToBeSorted
     * @param length
     */
    public void InsertionSort(Comparable[] arrayToBeSorted, int length ){
        for (int count = 1; count < arrayToBeSorted.length; count++) {
            int currentCount = count ; 
            while(currentCount - 1 >= 0 && arrayToBeSorted[currentCount].compareTo(arrayToBeSorted[currentCount -1]) < 0){
                swapArrayItems(arrayToBeSorted, currentCount, currentCount - 1);
                currentCount-- ;
            }
        }
    }
    /**
     * array will be sorted using quick sort algorithm
     * @param arrarToBeSorted
     * @param length
     */
    public void QuickSort(Comparable[] arrarToBeSorted, int length){
        QuickSort(arrarToBeSorted,0,arrarToBeSorted.length-1);
    }
    /**
     * private method to internally implement quicksort using start and end.
     * @param arrayToBeSorted
     * @param start
     * @param end
     */
    private void QuickSort(Comparable[] arrayToBeSorted, int start, int end) {
       if(start < end){
           int partition = getpartition(arrayToBeSorted, start, end);
           QuickSort(arrayToBeSorted, start,partition-1);
           QuickSort(arrayToBeSorted, partition + 1,end);
       }
       
       
    }
/**
 * return the appropriate partitioning value
 * @param arrayToBeSorted
 * @param start
 * @param end
 * @return correct partition index
 */
    private int getpartition(Comparable[] arrayToBeSorted, int start, int end){
        int partitionIndex = start;
        for (int count = start; count < end; count++) {
            if(arrayToBeSorted[count].compareTo(arrayToBeSorted[end])<=0){
                swapArrayItems(arrayToBeSorted, partitionIndex, count);
                partitionIndex++;
            }
        }
        swapArrayItems(arrayToBeSorted, partitionIndex, end);
        
        return partitionIndex;
    }
    
    
    /**
     * not an inplace sorting algorithm. 
     * stable algorithm (relative order remains the same)
     * O(n) space complexity
     * @param arrayToBeSorted
     * @param length
     */
    public void MergeSort(Comparable[] arrayToBeSorted, int length ){
        if(arrayToBeSorted.length > 1){
            int minIndex = getMinIndex(arrayToBeSorted.length - 1);
            Comparable[] leftHalf = (Comparable[]) getNewSubArray(arrayToBeSorted, 0, minIndex);
            Comparable[] rightHalf = (Comparable[]) getNewSubArray(arrayToBeSorted, minIndex + 1, arrayToBeSorted.length - 1);
            System.out.println("First half - " + arrayToBeSorted.length);
            MergeSort(leftHalf, leftHalf.length);
            System.out.println("Second half - " + arrayToBeSorted.length);
            MergeSort(rightHalf, rightHalf.length);
            mergeSortedArray(leftHalf, rightHalf, arrayToBeSorted);
        }
    }
    /**
     * returns a new sub array and assumes indexes as inclusive
     * @param originalArray
     * @param indexStart
     * @param indexLast
     * @return
     */
    private Comparable[] getNewSubArray(Comparable[] originalArray, int indexStart, int indexLast){
        Comparable[] resultArray = new Comparable[indexLast - indexStart + 1];
        int resultIndex = 0 ;
        for(int count = indexStart ; count <= indexLast ; count ++){
            resultArray[resultIndex] = originalArray[count];
            resultIndex++;
        }
        return resultArray;
    }
    private int getMinIndex(int arrayLength){
        return ((arrayLength % 2 == 0) ? arrayLength / 2 : (arrayLength + 1) / 2) - 1;
    }
    /**
     * method to merge 2 arrays 
     * @param arrayFirst
     * @param arraySecond
     * @param arrayResult
     */
    @SuppressWarnings("unchecked")
    private boolean mergeSortedArray(Comparable[] arrayFirst, Comparable[] arraySecond,Comparable[] arrayResult){
        boolean result = false;
        if((arrayFirst!=null && arraySecond != null && arrayResult != null ) 
            && (arrayResult.length == (arrayFirst.length + arraySecond.length))){ 
            result = true;
            int countFirst = 0 , countSecond = 0 , countResult = 0 ;
            // run loop to the maximum of both the arrays
            while(countFirst < arrayFirst.length || countSecond < arraySecond.length){
                // first condition when the bounds of each array is not completed
                if(countFirst < arrayFirst.length && countSecond < arraySecond.length){
                    if( arrayFirst[countFirst].compareTo(arraySecond[countSecond]) < 0){
                        arrayResult[countResult] = arrayFirst[countFirst];
                        countFirst++;
                    }else{
                        arrayResult[countResult] = arraySecond[countSecond];
                        countSecond++;
                    }
                }else if (countFirst <= arrayFirst.length - 1){
                    arrayResult[countResult] = arrayFirst[countFirst];
                    countFirst++ ;
                }else {
                    arrayResult[countResult] = arraySecond[countSecond];
                    countSecond++ ;
                }
                countResult++ ; 
            }   
        }
        return result;
    }
    private static void testMergeSortedArray() {
        Sorting sorting = new Sorting();
        Integer[] arrayFirst = new Integer[3];
        arrayFirst[0] = 1 ;
        arrayFirst[1] = 5 ;
        arrayFirst[2] = 9 ;

        Integer[] arraySecond = new Integer[10];
        arraySecond[0] = 2 ;
        arraySecond[1] = 3 ;
        arraySecond[2] = 4;
        arraySecond[3] = 6;
        arraySecond[4] = 7;
        arraySecond[5] = 10;
        arraySecond[6] = 11;
        arraySecond[7] = 12;
        arraySecond[8] = 15;
        arraySecond[9] = 16;
        
        
        Integer[] arrayResult = new Integer[arrayFirst.length + arraySecond.length];
        sorting.mergeSortedArray(arrayFirst, arraySecond, arrayResult);
        
    }
}
