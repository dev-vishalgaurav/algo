/**
 * https://leetcode.com/problems/4sum/ 
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 3 ; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                for(int j = i+1 ; j < nums.length - 2 ; j++){
                    if(j == i+1 || nums[j-1] != nums[j]){
                        // now its a 2 sum problem.
                        int k = j + 1, l = nums.length -1 ;
                        while(k < l ){
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if(sum == target){
                                List<Integer> quads = new ArrayList<>();
                                quads.add(nums[i]); quads.add(nums[j]); quads.add(nums[k]); quads.add(nums[l]);
                                result.add(quads);
                                k++; l--;
                                while(k < l && nums[k] == nums[k-1]) // check for duplicate j
                                    k++;
                                while(k < l && nums[l] == nums[l+1])// check for duplicate k
                                    l--;
                            }else if(sum < target){
                                k++;
                            }else{
                                l--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}