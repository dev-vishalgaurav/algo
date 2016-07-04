/**
 * https://leetcode.com/problems/wiggle-sort/
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        boolean isLess = true;
        for(int i = 0 ; i < nums.length -1 ; i++){
            if(isLess && nums[i] > nums[i+1])
                swap(nums,i,i+1);
            if(!isLess && nums[i] < nums[i+1] ) 
                swap(nums, i , i+1);
            isLess = !isLess;
        }
    }
    private void swap(int[] nums, int from , int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}