/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Solution {
	/**
	 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	 * https://www.youtube.com/watch?v=ZmnqCZp9bBs
	 */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int area = 0, n = heights.length, i = 0;
        Stack<Integer> s = new Stack<>(); // stack contains indexes.
        while(i <=n ){
            int h = (i == n ? 0 : heights[i]);
            if(s.isEmpty() || heights[s.peek()] <= h ) s.push(i++);
            else{ // i is not incremented in else part.
                int tp = s.pop();
                area = Math.max(area, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
            }
        }
        return area;
    }
	/**
	 * using array as a stack
	 */
	public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int area = 0, n = heights.length, i = 0, top = 0;
        int[] s = new int[n+1]; // stack contains indexes.
        while(i <= n ){ // == n is to prevent loop to empty stack after last element
            int h = (i == n ? 0 : heights[i]);
            if(top == 0 || heights[s[top-1]] <= h ) s[top++] = i++;
            else{ // i is not incremented in else part.
                int tp = s[--top];
                area = Math.max(area, heights[tp] * (top == 0 ? i : i - 1 - s[top-1]));
            }
        }
        return area;
    }
}