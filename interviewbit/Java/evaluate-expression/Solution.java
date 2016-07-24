/**
 * https://www.interviewbit.com/problems/evaluate-expression/
 */
public class Solution {
	public int evalRPN(ArrayList<String> a) {
        if(a == null || a.isEmpty()) return 0;
        String operators = "+-*/";
        long[] stack = new long[a.size()];
        int len = 0;
        for(String chunk : a){
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
}
