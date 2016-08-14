/**
 * https://leetcode.com/problems/basic-calculator/
 */
public class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1, len = s.length();
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                    
                result += num * sign;
            }else if(c == '+' || c == '-'){
                sign = c == '+' ? 1 : -1 ;
            }else if( c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(c == ')'){
                result = result * stack.pop() + stack.pop(); // first pop is for sign which says negative or positive.
            }
        }
        return result;
    }
	/**
	 * using array increases runtime.
	 */
	public int calculate(String s) {
        if(s == null || s.isEmpty()) return 0;
        int result = 0, sign = 1, len = s.length(),top = 0;
        int[] stack = new int[len];
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9' ){
                int num = c - '0';
                while(i + 1 < len && s.charAt(i+1)  >= '0' && s.charAt(i+1) <= '9')
                    num = num*10 + (s.charAt(i++ + 1) - '0');
                result += num * sign;
            }else if(c == '+' || c == '-'){
                sign = c == '+' ? 1 : -1 ;
            }else if( c == '('){
                stack[top++] = result; // push 
                stack[top++] = sign; // push
                result = 0;
                sign = 1;
            }else if(c == ')'){
                result = result * stack[--top] + stack[--top]; // first pop is for sign which says negative or positive.
            }
        }
        return result;
    }
}