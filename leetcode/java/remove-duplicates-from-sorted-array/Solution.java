/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int i = 0 , j = 1, n = nums.length;
        while(j < n){
            if(nums[j] == nums[i]) j++;
            else nums[++i] = nums[j++];
        }
        return i+1;
    }
}