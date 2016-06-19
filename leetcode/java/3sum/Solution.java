/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       return threeSum(nums,0);
    }
   public List<List<Integer>> threeSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    // -1,-1,0,1,2,4
    for(int i = 0 ; i < nums.length - 2 && nums[i] <= target ; i++){
        if(i == 0 || nums[i] > nums[i-1]){ // second condition checks for duplicate values;
            // now this is a 2sum problem where array is in sorted order. and target is subtracted by nums[i]
            int j = i + 1, k = nums.length -1;
            while(j < k && nums[i] + nums[j] <= target){
                int sum = nums[i] + nums[j] + nums[k];
                if( sum == target){
                    List<Integer> triplet = new ArrayList<>();
                    // add to triplet
                    triplet.add(nums[i]); triplet.add(nums[j]); triplet.add(nums[k]);
                    result.add(triplet);
                    j++; k--;
                    while(j < k && nums[j] == nums[j-1]) // check for duplicate j
                        j++;
                    while(k > j && nums[k] == nums[k+1])// check for duplicate k
                        k--;
                }else if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
            
        }
    }
    return result;
}
    
}