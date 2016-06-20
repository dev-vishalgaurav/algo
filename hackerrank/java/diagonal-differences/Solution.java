import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sumLeft = 0 ; 
        int sumRight = 0 ;
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                if(a_i == a_j){
                    sumLeft += a[a_i][a_j];
                }
                if(Math.abs(a_i + a_j) + 1 == n){
                    sumRight += a[a_i][a_j];
                }
            }
        }
        System.out.println(Math.abs(sumLeft - sumRight));
    }
}
