/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0 , n = nums.length;
        while(i < n){
            if(nums[i] < n && nums[i] >= 0 && nums[i] != nums[nums[i]] ){
                swap(nums,i,nums[i]);
            }else{
                i++;
            }
        }
        int k = 1;
        while( k < n && k == nums[k]) k++;
        
        if(n == 0 || n < k) return k;
        else return nums[0] == k ? k + 1: k;
    }
    
    private void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
	/**
	 * Not O(n) space
	 */
	public int firstMissingPositive(int[] nums) {
        int result = 1 ;
        int maxNumber = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > maxNumber){
                maxNumber = nums[i];
            }
        }
        
       int[] totalNums = new int[maxNumber+2];
       for(int i = 0 ; i < nums.length ; i++){
           if(nums[i] > 0){
               totalNums[nums[i]]++;
           }
       }
       for(int i = 1 ; i < totalNums.length ; i++){
           if(totalNums[i] == 0){
              result = i;
              break;
           }
       }
       return result;
    }
}