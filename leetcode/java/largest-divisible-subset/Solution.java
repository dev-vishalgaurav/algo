/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0 ) return result;
        Arrays.sort(nums);
        int maxSubset = 1, startIndex = nums.length - 1, count = 0 ;
        int[] sets = new int[nums.length], dp = new int[nums.length];
        for(int i = nums.length - 1 ; i >= 0 ; i-- ){
            for(int j = i ; j < nums.length ; j++){
                if(nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    sets[i] = j;
                    if(maxSubset < dp[i]){
                        maxSubset = dp[i];
                        startIndex = i;
                    }
                }
            }
        }
        for(count = 0 ; count < maxSubset; count++){
            result.add(nums[startIndex]);
            startIndex = sets[startIndex];
        }
        return result;
    }
}