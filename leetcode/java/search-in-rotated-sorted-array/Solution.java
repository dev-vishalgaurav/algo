/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length - 1, lo = 0, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > nums[hi]){
                if(target < nums[mid] && target > nums[hi]) hi = mid -1;
                else lo = mid + 1;
            }else if (nums[mid] < nums[hi]){
                if(target < nums[mid] || target > nums[hi]) hi = mid -1;
                else lo = mid + 1;
            }else{
                hi--;
            } 
        }
        return -1;
    }
}