import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/balanced-parentheses
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < testCases; i++){
            System.out.println(isBalanced(scanner.nextLine()) ? "YES":"NO");
        }
    }
    
    private static boolean isOpener(char c){
        return c == '(' || c == '{' || c == '[';
    }
    private static boolean isCloser(char c){
        return c == ')' || c == '}' || c == ']';
    }
    private static boolean isComplement(char opener, char closer){
        if(opener == '(') return closer == ')';
        if(opener == '{') return closer == '}';
        if(opener == '[') return closer == ']';
        return false;
    }
    private static boolean isBalanced(String input){
        int count = 0 ;
        Stack<Character> stack = new Stack<>();
        while(count < input.length()){
            char c = input.charAt(count);
            if(isOpener(c))
                stack.push(c);
            else if (isCloser(c)){
                if(stack.isEmpty())
                        return false;
                char top = stack.peek();
                if(isComplement(top,c))
                    stack.pop();
                else 
                    return false;
            }else{
                return false;
            }
            count++;
        }
        return stack.isEmpty();
    }
    
}