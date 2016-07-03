/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        utils(0,nums,new ArrayList<Integer>(),result);
        return result;
    }
    /**
     * discarding the duplicate values by checking previous element 
     */
    private void utils(int start,int[] nums, ArrayList<Integer> set, List<List<Integer>> result){
        result.add(set);
        for(int i = start ; i < nums.length; i++){
            if(i == start || (i > start && nums[i] != nums[i-1])){
                ArrayList<Integer> next = new ArrayList<>(set);
                next.add(nums[i]);
                utils(i+1,nums,next,result);
            }
        }
    }
    /**
     * same as above except above if condition
     */
    private void utils(int start,int[] nums, ArrayList<Integer> set, List<List<Integer>> result){
        result.add(set);
        for(int i = start ; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            ArrayList<Integer> next = new ArrayList<>(set);
            next.add(nums[i]);
            utils(i+1,nums,next,result);
        }
    }
    /**
     * using Hashsets
     */
    private void utils(int start,int[] nums, ArrayList<Integer> set, List<List<Integer>> result){
        result.add(set);
        HashSet<Integer> visited = new HashSet<>();
        for(int i = start ; i < nums.length; i++){
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
                ArrayList<Integer> next = new ArrayList<>(set);
                next.add(nums[i]);
                utils(i+1,nums,next,result);
            }
        }
    }
}