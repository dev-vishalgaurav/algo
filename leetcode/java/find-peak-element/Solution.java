/**
 *  https://leetcode.com/problems/find-peak-element/
 */
public class Solution {
	/**
	 *
	 * Naive solution O(n) time 
	 */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        int maxIndex = nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1  ;
        for(int i = 1 ; i < nums.length  - 1 ; i++){
            if(nums[i] > nums[i -1] && nums[i] > nums[i + 1] && nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
	
	/**
	 * Using binary search very long code O (logn)
	 */
	public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1])
                    return mid;
                else low = mid + 1;
            }else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid-1])
                    return mid;
                else high = mid - 1;
            }else{
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid + 1])
                    return mid;
                else if(nums[mid] < nums[mid - 1])
                    high = mid -1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
	/**
	 * very short code based on previous logic but very short. thanks to below mentioned code 
	 * https://leetcode.com/discuss/96588/general-binary-search-in-java
	 */
	public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < nums[mid+1])
                lo = mid + 1;
            else 
                hi = mid;
        }
        return lo;
    }
}