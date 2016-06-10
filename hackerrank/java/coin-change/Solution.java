import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
* https://www.hackerrank.com/challenges/coin-change
*/
public class Solution {

    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int total = Integer.parseInt(firstLine[0]);
        String[] coins = scanner.nextLine().split(" ");
        long[][] dpTable = new long[coins.length][total + 1];
        for(int i = 0 ; i < coins.length ; i++)
            dpTable[i][0] = Integer.parseInt(coins[i]);
        System.out.println(getWays(dpTable));
    }
    private static long getWays(long[][] dpTable){
        for(int j = 1 ; j < dpTable[0].length ; j++)
            for(int i = 0 ; i < dpTable.length ; i++){
                int coinVal = (int) dpTable[i][0] ;
                long currentVal = (i - 1 >= 0) ? dpTable[i-1][j] : 0;
                if( j == coinVal) 
                    currentVal++;
                if (j > coinVal)  
                    currentVal += dpTable[i][j - coinVal];
                dpTable[i][j] = currentVal;
            }
        return dpTable[dpTable.length - 1][dpTable[0].length -1];
    }
}