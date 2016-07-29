/**
 * https://leetcode.com/problems/sort-colors/
 */
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0 ) return;
        int i = 0, pivot = 0, j = nums.length - 1;
        while(i <= j){
            if(nums[i] == 0) swap(nums,i++,pivot++);
            else if(nums[i] == 2) swap(nums,i,j--);
            else i++;
        }
    }
    private void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

}