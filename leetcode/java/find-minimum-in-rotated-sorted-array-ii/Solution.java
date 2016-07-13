/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length -1, mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] > nums[hi]) 
                lo = mid + 1;
            else if(nums[mid] < nums[hi]) 
                hi = mid;
            else hi--;
        }
        return nums[lo];
    }
}