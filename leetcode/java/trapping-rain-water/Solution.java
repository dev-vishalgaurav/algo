/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class Solution {
	/**
	 * using stack.
	 */
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;
        int total = 0, i = 0;
        Stack<Integer> s = new Stack<>();
        while(i < height.length){
            if(s.isEmpty() || height[i] <= height[s.peek()]) s.push(i++);
            else{
                int cur = height[s.pop()];
                if(s.isEmpty()) continue;
                int length = Math.min(height[s.peek()],height[i]) - cur; 
                int width = (i - s.peek() - 1 );
                total += length * width;  
            }
        }
        return total;
    }
	/**
	 * Using 2 pointers 
	 * https://discuss.leetcode.com/topic/5125/sharing-my-simple-c-code-o-n-time-o-1-space
	 */
	public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;
         int l = 0, r = height.length-1, level = 0, water = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            water += level - lower;
        }
        return water;
    }
}