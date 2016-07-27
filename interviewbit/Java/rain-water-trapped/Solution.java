/**
 * https://www.interviewbit.com/problems/rain-water-trapped/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> height) {
	    if(height == null || height.size() <= 2) return 0;
        int total = 0, i = 0;
        Stack<Integer> s = new Stack<>();
        while(i < height.size()){
            if(s.isEmpty() || height.get(i) <= height.get(s.peek())) s.push(i++);
            else{
                int cur = height.get(s.pop());
                if(s.isEmpty()) continue;
                int length = Math.min(height.get(s.peek()),height.get(i)) - cur; 
                int width = (i - s.peek() - 1 );
                total += length * width;  
            }
        }
        return total;
	}
}
