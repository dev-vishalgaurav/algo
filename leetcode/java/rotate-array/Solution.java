/**
 * https://leetcode.com/problems/rotate-array/
 *
 */
public class Solution {
	/**
	 * O(n) time O(1) space 
	 */
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || (k = k % nums.length) == 0 ) return;
        reverse(nums, 0, nums.length -1);
        reverse(nums,0,k-1);
        reverse(nums, k, nums.length -1);
    }
	/**
	 * O(n) time O(n) space 
	 */
	public void rotate(int[] nums, int k) {
        if(nums.length == 0 || (k = k % nums.length) == 0 ) return;
        int[] shifts = new int[k];
        for(int i = nums.length - k, j = 0 ; i < nums.length ; i++, j++)
            shifts[j] = nums[i];
        for(int i = nums.length - k - 1 ; i >= 0 ; i-- )
            nums[i+k] = nums[i];
        for(int i = 0 ; i < k ; i ++)
            nums[i] = shifts[i];
    }
	
	/**
	 * this reverse the array. 
	 */
    private void reverse(int[] nums, int start, int end){
        int mid = start + (end - start)/2;
        int total = mid - start;
        for(int i = 0 ; i <= total ; i++){
            int from = start + i, to = end - i;
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
        }
    }
	
}