import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
* https://www.hackerrank.com/challenges/the-love-letter-mystery
*/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < testCases; i++){
            System.out.println(getOperations(scanner.nextLine()));
        }
    }
    
    private static int getOperations(String word){
        int operations = 0 ;
        if(word.length() > 1){
            int length = word.length();
            int maxIndex = length - 1;
            for(int i = 0 ; i < length / 2 ; i++ ){
                operations += Math.abs((word.charAt(i) - 'a') - (word.charAt(maxIndex - i) - 'a'));
            }
        }
        return operations;
    }
}