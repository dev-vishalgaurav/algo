/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2 ) return nums.length;
        int i = 1, j = 2, n = nums.length;
        while(j < n){
            if(nums[j] == nums[i] && nums[i] == nums[i-1]) j++;
            else nums[++i] = nums[j++]; 
        }
        return i+1;
    }
}