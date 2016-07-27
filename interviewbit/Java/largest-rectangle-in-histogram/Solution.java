/**
 * https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 */
public class Solution {
	public int largestRectangleArea(ArrayList<Integer> heights) {
	    if(heights == null || heights.size() == 0) return 0;
        int area = 0, n = heights.size(), i = 0, top = 0;
        int[] s = new int[n+1]; // stack contains indexes.
        while(i <= n ){ // == n is to prevent loop to empty stack after last element
            int h = (i == n ? 0 : heights.get(i));
            if(top == 0 || heights.get(s[top-1]) <= h ) s[top++] = i++;
            else{ // i is not incremented in else part.
                int tp = s[--top];
                area = Math.max(area, heights.get(tp) * (top == 0 ? i : i - 1 - s[top-1]));
            }
        }
        return area;
	}
}
