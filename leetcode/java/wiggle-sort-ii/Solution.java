/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class Solution {
	/**
	 * NLogN time and O(n) space
	 * TODO use 3 way partition for O(n) and O(1)
	 */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        int left = nums.length - 1;
        int right = left / 2;
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = (i & 1) == 0 ? copy[right--] : copy[left--];
        }
    }
}