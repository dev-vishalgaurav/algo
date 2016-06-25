import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger num = new BigInteger("1");
        for(int i = 1 ; i <= n ; i++ ){
            num = num.multiply(new BigInteger(""+i));
        }
        System.out.println(num.toString());
    }
}
