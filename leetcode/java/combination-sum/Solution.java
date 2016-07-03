/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if((i == 0 || nums[i] != nums[i-1]) && target - nums[i] >= 0){
                path.add(nums[i]);
                utils(target - nums[i],i,nums,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}