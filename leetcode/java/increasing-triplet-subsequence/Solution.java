/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Solution {
	/**
	 * with array 
	 */
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int[] dp = new int[3];
        int maxLen = 0;
        for(int val : nums){
            if(maxLen == 0 || val > dp[maxLen - 1]){
                dp[maxLen++] = val;
            }else if(dp[0] >= val){
                dp[0] = val;
            }else if(maxLen > 1 && dp[1] >= val){
                dp[1] = val;
            }
            if(maxLen == 3) return true;
        }
        return false;
    }
	/**
	 * without using array.
	 */
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        int maxLen = 0;
        for(int val : nums){
            if(val <= first){
                first = val;
            }else if(val <= second){
                second = val;
            }else{
                return true;
            }
        }
        return false;
    }
}