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
}