/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Solution {
	/**
	 * Using Arrays, beats 99.5 precent 
	 */
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        String operators = "+-*/";
        long[] stack = new long[tokens.length];
        int len = 0;
        for(String chunk : tokens){
            int index = operators.indexOf(chunk); 
            if( index >= 0){
                if(len < 2) return 0; // invalid string return infinity
                long second = stack[--len], first = stack[--len];
                if(index == 0)      stack[len++] = first + second;
                else if(index == 1) stack[len++] = first - second;
                else if(index == 2) stack[len++] = first * second;
                else if(index == 3) stack[len++] = first / second;
            }else
                stack[len++] = Long.parseLong(chunk);
        }
        return (int) (len == 1 ? stack[0] : 0);
    }
	/**
	 * Using inbuild Stack DS.
	 */
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        String operators = "+-*/";
        Stack<Long> stack = new Stack<>();
        for(String chunk : tokens){
            int index = operators.indexOf(chunk); 
            if( index >= 0){
                if(stack.size() < 2) return 0; // invalid string return infinity
                long second = stack.pop(), first = stack.pop();
                if(index == 0) stack.push(first + second);
                else if(index == 1) stack.push(first - second);
                else if(index == 2) stack.push(first * second);
                else if(index == 3) stack.push(first / second);
            }else{
                stack.push(Long.parseLong(chunk));
            }
        }
        return (int) (stack.size() == 1 ? stack.peek() : 0);
    }
}