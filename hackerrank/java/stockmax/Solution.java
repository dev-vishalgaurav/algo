import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 *
 * https://www.hackerrank.com/challenges/stockmax
 */ 
public class Solution {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < testCases ; i++){
            scanner.nextLine();
            System.out.println(getProfit(scanner.nextLine().split(" ")));
        }
    }
    
    private static long getProfit(String[] stockPrices){
        long profit = 0 ; 
        long maxSoFar = 0;
        for(int i = stockPrices.length - 1; i >= 0 ; i--){
            long currentPrice = Long.parseLong(stockPrices[i]);
            if(currentPrice >= maxSoFar){
                maxSoFar = currentPrice;
            }
            profit += maxSoFar - currentPrice;
        }
        return profit;
    }
}