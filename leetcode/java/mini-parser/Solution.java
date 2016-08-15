/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 * https://leetcode.com/problems/mini-parser/
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s == null || s.isEmpty()) return new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        int sign = 1, len = s.length() ;
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c == '['){
                stack.push(new NestedInteger());
            }else if( c == ']'){
                if(stack.size() > 1){
                    NestedInteger n = stack.pop();
                    stack.peek().add(n);   
                }
            }else if(c == '-'){
                sign = -1;
            }
            else if(Character.isDigit(c)){
                int num = c - '0';
                while( i + 1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                num = num * sign;
                sign = 1;
                if(!stack.isEmpty()){
                    NestedInteger n = stack.pop();
                    n.add(new NestedInteger(num));
                    stack.push(n);
                }else{
                    stack.push(new NestedInteger(num));
                }
            }
        }
        return stack.isEmpty() ? new NestedInteger() : stack.pop() ; 
    }
}