/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        utils(target,0,candidates,new ArrayList<Integer>(),result);
        return result;
    }
    private void utils(int target,int start, int[] nums, List<Integer> path,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start ; i < nums.length ; i++){
            if(i > start && nums[i] == nums[i-1]) continue; //  this condition is important to avoid duplicates.
            if(target - nums[i] >= 0){
                path.add(nums[i]);
                utils(target - nums[i],i+1,nums,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}