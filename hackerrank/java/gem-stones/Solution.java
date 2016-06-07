import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
*https://www.hackerrank.com/challenges/gem-stones
**/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] words = new String[testCases];
        for(int i = 0 ; i < testCases; i++){
            words[i] = scanner.nextLine();
        }
        System.out.println(getGemElementNumber(words));
    }
    
    private static int getGemElementNumber(String[] words){
        int count = 0;
        int[] map = new int[26];
        for(int i = 0 ; i < words.length ; i++)
               updateMap(words[i],map,i+1);
        for(int num : map)
            if(num == words.length)
                count++;
        return count;
    }
    
    private static void updateMap(String word, int[] map, int base){
        boolean[] isVisited = new boolean[26];
        for(int i = 0 ; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(map[index] < base && !isVisited[index]){
                map[index]++;
                isVisited[index] = true;
            }
        }
    }
}