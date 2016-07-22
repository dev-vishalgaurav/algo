/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, len = nums.length, start = 1;
        if(nums.length <= 1) return len;
        while(start < n && nums[0] == nums[start]){ 
            start++;
            len--;
        }
        if(start == n) return len;
        boolean nextSmaller = nums[start] > nums[start - 1];
        int prev = nums[start];
        for(int i = start + 1 ; i < n ; i++){
            if(nextSmaller && nums[i] >= prev || !nextSmaller && nums[i] <= prev)
                 len--;
            else 
                nextSmaller = !nextSmaller;
            prev = nums[i];
        }
        return len;   
    }
}