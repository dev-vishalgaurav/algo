/**
 * https://leetcode.com/problems/jump-game/
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > max) return false;
            max = Math.max(max,nums[i] + i);
        }
        return true;
    }
}