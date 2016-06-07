import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
*https://www.hackerrank.com/challenges/maxsubarray
*/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < testCases ; i++){
            int arraySize = Integer.parseInt(scanner.nextLine());
            int[] input = new int[arraySize];
            String[] inputStr = scanner.nextLine().split(" ");
            for(int j = 0 ; j < arraySize; j++){
                input[j] = Integer.parseInt(inputStr[j]);
            }
            System.out.println("" + getMaxSubContiguous(input) + " " + getMaxSubArray(input)) ;
        }
    }
    private static int getMaxSubArray(int[] input){
        int result = 0;
        if(input.length > 0){
            result = input[0];
            for (int i = 1; i < input.length; i++) {
                if(result + input[i] > result){
                    result = Math.max(input[i],result + input[i]);
                }else{
                    result = Math.max(result, input[i]);
                }
            }
        }
        return result;
    }
    private static int getMaxSubContiguous(int[] input) {
        int result = 0; // 0 = contiguous sum
        int currentMax = 0;
        if(input.length > 0){
            result = input[0];
            currentMax = input[0];
            for (int i = 1; i < input.length; i++) {
                if(currentMax + input[i] > 0){
                    currentMax = Math.max(input[i],currentMax + input[i]);
                }else{
                    currentMax = input[i];
                }
                result = Math.max(currentMax, result);
            }
        }
        return result;
    }
}