/**
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> nums, int target) {
	    int hi = nums.size() - 1, lo = 0, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(nums.get(mid) == target) return mid;
            else if(nums.get(mid) > nums.get(hi)){
                if(target < nums.get(mid) && target > nums.get(hi)) hi = mid -1;
                else lo = mid + 1;
            }else if (nums.get(mid) < nums.get(hi)){
                if(target < nums.get(mid) || target > nums.get(hi)) hi = mid -1;
                else lo = mid + 1;
            }else{
                hi--;
            } 
        }
        return -1;
	}
}
