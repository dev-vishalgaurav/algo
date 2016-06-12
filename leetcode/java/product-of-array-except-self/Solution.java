/**
* https://leetcode.com/problems/product-of-array-except-self/
*/
public class Solution {
	
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] front = new int[nums.length];
        front[0] = nums[0];
        int[] back = new int[nums.length];
        back[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1 ; i < nums.length ; i++){
            front[i] = nums[i] * front[i-1];
        }
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            back[i] = nums[i] * back[i+1];
        }
        output[0] = back[1];
        output[nums.length -1] = front[nums.length -2];
        for(int i = 1 ; i < nums.length - 1 ; i++){
            output[i] = front[i-1] * back[i+1];
        }
        return output;
    }
}