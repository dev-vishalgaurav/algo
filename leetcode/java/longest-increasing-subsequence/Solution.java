/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Solution {
	/**
	 * Naive DP Solution 
	 */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length] ;
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
    	    dp[i] = 1;
    	    for(int j = i - 1 ; j >= 0 ; j--){
    		    if(nums[i] > nums[j] && dp[i] <= dp[j])
    			    dp[i] = dp[j] + 1;
    	    }
    	    max = Math.max(dp[i],max);
        }
        return max;             
    }
	/**
	 * using java builtin binary search method. Very less code
	 */
	public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length] ;
        int maxLen = 0;
        for(int val : nums){
            if(maxLen == 0 || val > dp[maxLen - 1]){
                 dp[maxLen++] = val; 
            }else{
                int insertIndex = Arrays.binarySearch(dp,0,maxLen,val);
                if(insertIndex < 0) insertIndex = - ( insertIndex + 1);
                dp[insertIndex] = val;
            }
        }
        return maxLen;             
    }
	/**
	 * using binary search technique but very long code. n logn
	 */
	public int lengthOfLIS(int[] nums) {
        int max = 0 ;
        if(nums.length > 0){
            int[] temp = new int[nums.length];
            int currentLength = 0 ;
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] > nums[temp[currentLength]]){
                    // extend the list
                    currentLength++;
                    temp[currentLength] = i ;
                }else if(nums[i] < nums[temp[0]]){
                    // replace the shortest
                    temp[0] = i;
                }else if(nums[i] > nums[temp[0]] && nums[i] < nums[temp[currentLength]]){ // for equalto condition
                    // is in between .. need to do binarSearch for ceil value
                    int replaceIndex = getIndex(nums,temp,nums[i],currentLength);
                    temp[replaceIndex] = i;
                }
            }
            max = currentLength + 1;
        }
        return max;
    }
    
    private int getIndex(int[] nums, int[] temp, int forValue, int currLength){
        int high = currLength;
        int low = 0;
        int mid  = -1;
        int result = -1;
        while(low <= high){
           mid =  low + (high - low)/2;
           if(forValue == nums[temp[mid]]){
               result = mid;
               break;
           }else if(mid < currLength && nums[temp[mid]] < forValue && nums[temp[mid+1]] >= forValue ){
               result = mid + 1;
               break;
           }else if(nums[temp[mid]] > forValue){
               high = mid - 1 ; 
           }else{
               low = mid + 1;
           }
        }
        return result;
    }
    
}