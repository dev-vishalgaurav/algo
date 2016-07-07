/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/ 
 */
public class Solution {
	/**
	 * https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
	 */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE ; // negative infinity
        for(int val : preorder ){
            if(min > val) return false;
            while(!stack.isEmpty() && stack.peek() < val)
                min = stack.pop();
            stack.push(val);
        }
        return true;
    }
}