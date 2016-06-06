import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < testCases; i++){
            System.out.println(getDeletionCount(scanner.nextLine()));
        }
    }
    
    private static int getDeletionCount(String word){
        int deletion = 0 ;
        if(word.length() > 0){
            char prev = word.charAt(0);
            for(int i = 1 ; i < word.length() ; i++){
                char current = word.charAt(i);  
                if(current == prev)
                     deletion++;
                prev = current;
            }
        }
        return deletion;
    }
}