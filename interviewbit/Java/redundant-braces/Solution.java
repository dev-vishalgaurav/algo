/**
 * https://www.interviewbit.com/problems/redundant-braces/
 */
public class Solution {
	public int braces(String a) {
	   Stack<Character> stack = new Stack<>();
        String ops = "*-+/";
        for(int i = 0 ; i < a.length(); i++){
            char c = a.charAt(i);
            if(ops.indexOf(c) >= 0 || c == '(') stack.push(c);
            else if(c == ')'){
                if(stack.peek() == '(') return 1;
                while(!stack.isEmpty() && stack.peek() != '(') stack.pop();
                stack.pop(); // remove '('
            }
        }
        return 0;
	}
}
