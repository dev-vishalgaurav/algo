import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/simple-text-editor
 */
public class Solution {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < tests ; i++){
            String[] split = scanner.nextLine().split(" ");
            int op = Integer.parseInt(split[0]);
            if(op == 1) {
                String s = split[1];
                ops.push(sb.toString());
                sb.append(s);
            }else if(op == 2){
                ops.push(sb.toString());
                sb = sb.delete(sb.length() - Integer.parseInt(split[1]),sb.length());
            }else if(op == 3){
                 System.out.println(sb.charAt(Integer.parseInt(split[1]) - 1));
            }else if(op == 4){
                if(!ops.isEmpty()){
                    sb = new StringBuilder(ops.pop());
                }
            }
        }                          
    }
}