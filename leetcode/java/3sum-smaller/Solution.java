/**
 * https://leetcode.com/problems/3sum-smaller/
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0 ;
        for(int i = 0 ; i < nums.length - 2; i++ ){
                int j = i+1, k = nums.length - 1;
                int sum;
                while(j < k){
                    sum = nums[i] + nums[j] + nums[k];
                    if(sum < target){
                        result += (k - j) ; // this part is important.
                        j++;
                    }else{
                        k--;
                    }
                }
        }
        return result;
    }
}