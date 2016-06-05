import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < testCases ; i++){
            String result = getNext(scanner.nextLine());
            if(result != null){
                System.out.println(result);
            }else{
                System.out.println("no answer");
            }
        }
    }
    private static String getNext(String s){
        char[] input = s.toCharArray();
        for(int i = input.length - 1; i > 0 ; i--){
            if(input[i-1] < input[i]){
                int swapIndex = getCorrectIndex(input,i,input[i-1]);
                swap(input,swapIndex,i-1);
                Arrays.sort(input,i,input.length);
                return new String(input);
            }
        }
        return null;
    }
    private static int getCorrectIndex(char[] input, int start, char toSwap){
        int result = start;
        for(int i = start; i < input.length ; i++){
            if(input[i] < input[result] && input[i] > toSwap){
                result = i;
            }
        }
        return result;
    }
    private static void swap(char[] array, int from, int to) {
        char temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}