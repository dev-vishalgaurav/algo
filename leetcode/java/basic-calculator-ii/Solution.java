/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Solution {
	public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0 , len = s.length();
        char sign = '+';
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)){
                int num = 0;
                num = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop() * num);
                if(sign == '/') stack.push(stack.pop() / num);
            }else{
                sign = c;
            }
        }
        while(!stack.isEmpty()) 
            result += stack.pop();
        return result;
    }
	 /**
	  * Using postfix notation
	  */
     public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> postFix = new ArrayList<>();
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i++ + 1) - '0';
                }
                postFix.add(String.valueOf(num));
            }else if(c == '*' || c == '/'){
                while(!stack.isEmpty() && (stack.peek() == '/' || stack.peek() == '*')){
                    postFix.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }else if ( c == '+' || c == '-'){
                while(!stack.isEmpty()){
                    postFix.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
             postFix.add(String.valueOf(stack.pop()));
        }
        return evaluatePostFix(postFix);
    }
    
    int getVal(Integer second, Integer first, char token){
        if(token == '+') return first + second;
        if(token == '-') return first - second;
        if(token == '*') return first * second;
        if(token == '/') return first / second;
        return 0;
    }
    
    private int evaluatePostFix(ArrayList<String> postfix){
        Stack<Integer> stack = new Stack<>();
        for(String token : postfix){
            if("*+-/".indexOf(token) >= 0){
                stack.push(getVal(stack.pop(),stack.pop(),token.charAt(0))); 
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop() ;
    }
    
}