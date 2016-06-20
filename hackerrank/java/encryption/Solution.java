import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/encryption
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        encodeText(s);
    }
    
    private static void encodeText(String text){
        double sqrt = Math.sqrt(text.length());
        int column = (int ) Math.ceil(sqrt);
        int rows = (int ) Math.floor(sqrt);
        if(rows != column && rows * column < text.length() ) rows++;
        for(int i = 0 ; i < column ; i++){
            for(int j = 0 ; j < rows ; j++){
                int index = i + j * column ;
                if(index < text.length())
                    System.out.print(text.charAt(index));
            }
            System.out.print(" ");
        }
    }
}
