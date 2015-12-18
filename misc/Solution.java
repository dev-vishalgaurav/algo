/**
* This will contain solutions for the questions which doesn't find place at any of the directories in algo. Solutions are not checked on any OJ. So it may
miss some test cases or corner cases.
*/
public class Solution {
/**
 * <p>
 * Given an array of integers. Modify the array by moving all the zeros to
 * the end (right side). The order of the other elements doesn't matter.
 * </p>
 *
 * Note :- question taken from career cup 
 */
    static void shiftZerosToRight(int[] inputArray) {
        int maxLength = inputArray.length;
        int nextZeroPosition = maxLength - 1  ;
        if (inputArray != null && inputArray.length > 0) {
            for (int count = 0; count < inputArray.length; count++) {
                if(inputArray[count] == 0 ){
                    while(inputArray[nextZeroPosition] == 0 && nextZeroPosition > 0){
                        nextZeroPosition -- ;
                    }
                    if(nextZeroPosition <= count ){
                        break ;// no shifting
                    }
                    inputArray[count] = inputArray[nextZeroPosition];
                    inputArray[nextZeroPosition] = 0 ;
                }
            }
        }
        for (int count = 0; count < inputArray.length; count++) {
            System.out.print(inputArray[count] + " ");
        }
    }
/**
 * <p>
 * Given an array of positive integers (excluding zero) and a target number.
 * Detect whether there is a set of consecutive elements in the array that
 * add up to the target. <br>
 * <br>
 * Example: a = {1, 3, 5, 7, 9} <br>
 * target = 8 <br>
 * <br>
 * output = true ({3, 5}) <br>
 * <br>
 * or target = 15 <br>
 * output = true : {3, 5, 8} <br>
 * 
 * Careercup question 
 *
 * @param inputArray
 * @param target
 */
    static void findSetToTarget(int[] inputArray, int target) {
        int currentIndex = 0;
        int currentNumber = inputArray[currentIndex];
        int currentSum = currentNumber;
        int count = 1;
        while (count < inputArray.length && currentIndex < inputArray.length) {
            currentSum += inputArray[count];
            if (currentSum < target) {
                count++;
            } else if (currentSum > target) {
                currentIndex++;
                count = currentIndex + 1;
                currentSum = inputArray[currentIndex];
            } else { // target found
                for (int start = currentIndex; start <= count; start++) {
                    System.out.print(inputArray[start] + " ");
                }
                System.out.println("");
                currentIndex++;
                count = currentIndex + 1;
                currentSum = inputArray[currentIndex];
                // find next

            }
        }

    }
}