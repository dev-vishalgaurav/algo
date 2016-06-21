/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0 ;
        if(nums.length == 1) return nums[0] >= s ? 1 : 0 ;
        int result = 0, start = 0, end = 1, sum = nums[0];
        while(start < end && end < nums.length){
            if(nums[start] >= s || nums[end] >= s) return 1;
            sum += nums[end];
            if(sum >= s){
                while(sum - nums[start] >= s && start < end){
                    sum -= nums[start];
                    start++;
                }
                int size = end - start + 1 ;
                result = (result == 0) ? size : Math.min(size,result);
                sum = sum - nums[start] ;
                end++;
                start++;
            }else{
                end++;
            }
        }
        return result;
    }
}