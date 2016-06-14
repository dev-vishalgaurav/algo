/**
* https://leetcode.com/problems/maximum-product-subarray/
*/
public class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0], max = nums[0], min = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > 0){
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]) ;
            }else{
                int prevMax = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], prevMax * nums[i]);
            }
            result = Math.max(result,max);
        }
        return result;
    }
}