import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNum = scanner.nextLine();
        String secondNum = scanner.nextLine();
        System.out.println(getDeletionCount(firstNum,secondNum));
    }
    
    private static int getDeletionCount(String firstNum, String secondNum){
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int deletions = 0 ;
        for(int i = 0 ; i < firstNum.length() ; i++){
            map1[firstNum.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < secondNum.length() ; i++){
            map2[secondNum.charAt(i) - 'a']++;            
        }
        for(int i = 0 ; i < 26; i++){
            deletions += Math.abs(map1[i] - map2[i]);      
        }
        
        return deletions;
    }
}