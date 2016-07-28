/**
 * https://leetcode.com/problems/search-for-a-range/
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBSearch(nums,target);
        if(left == -1) return new int[]{-1,-1};
        return new int[]{left,rightBSearch(nums,target)};
    }
    
    private int leftBSearch(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if((mid == 0 || nums[mid-1] < target) && nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
    private int rightBSearch(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if((mid == nums.length - 1 || nums[mid+1] > target) && nums[mid] == target) return mid;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
        
    }
	/**
	 * Using single search function
	 */
	public int[] searchRange(int[] nums, int target) {
        int left = search(nums,target);
        if(left == nums.length || nums[left] != target) return new int[]{-1,-1};
        return new int[]{left,search(nums,target+1) - 1};
    }
    
    private int search(int[] nums, int target){
        int lo = 0, hi = nums.length, mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}