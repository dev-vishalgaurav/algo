/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int area = 0 , i = 0 , j = height.length -1, n = height.length;
        while(i < j){
            int w = j - i;
            int h = height[i] > height[j] ? height[j--] : height[i++];
            area = Math.max(area, w * h); 
        }
        return area;
    }
	/**
	 * Shorter version
	 */
	public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int area = 0 , i = 0 , j = height.length -1, n = height.length;
        while(i < j){
            area = Math.max(area, (j-i) * (height[i] > height[j] ? height[j--] : height[i++])); 
        }
        return area;
    }
}