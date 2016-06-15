import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * https://www.hackerrank.com/challenges/maximum-element/
 */
public class Solution {
    private static class Node{
        private int num;
        private int max;
        Node(int num, int max){
            this.num = num;
            this.max = max;
        }
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int queries = scanner.nextInt();
       Stack<Node> stack = new Stack<>();
       for(int i = 0 ; i < queries ; i++){
           int type = scanner.nextInt(); 
           if(type == 1){
               int number = scanner.nextInt();
               int max = number;
               if(!(stack.size() == 0 || number > stack.peek().max)){
                   max = stack.peek().max;
               }
               stack.push(new Node(number,max));
           }else if(type == 2)
                   stack.pop();
           else if(type == 3)
                   System.out.println(stack.peek().max);
       }
    }
}