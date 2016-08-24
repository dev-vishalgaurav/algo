/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length, maxRight = 0 , minLeft = 0, steps = 0;
        for(int i = 0 ; i < n && minLeft < n-1 ; i++){
            maxRight = Math.max(i+nums[i],maxRight);
            if(i == minLeft){
                steps++;
                minLeft = maxRight;
            }
        }
        return steps;
    }
}