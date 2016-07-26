/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        for(int i = 1 ; i <= target ; i++){
            for(int num : nums){
                if(num > i) continue;
                if(num == i) dp[i] += 1;
                if(num < i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    /**
    * Using sort
    */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        for(int i = 1 ; i <= target ; i++){
            for(int num : nums){
                if(num > i) break;
                if(num == i) dp[i] += 1;
                if(num < i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}