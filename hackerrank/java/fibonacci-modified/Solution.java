import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger prev = new BigInteger(""+ scanner.nextInt());
        BigInteger num = new BigInteger(""+ scanner.nextInt());
        int N = scanner.nextInt();
        BigInteger temp = null;
        for(int i = 3 ; i <= N ; i++){
            temp = num;
            num = num.multiply(num);
            num = num.add(prev);
            prev = temp;
        }
        System.out.println(num);
    }
}