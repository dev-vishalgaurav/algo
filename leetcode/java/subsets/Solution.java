/**
 * https://leetcode.com/problems/subsets/
 */
public class Solution {
    /**
     * not so elegant solution.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i <=nums.length ; i++){
            ArrayList<Integer> set = new ArrayList<>();
            utils(0,i,nums,set,result);
        }
        return result;
    }
    
    private void utils(int start,int length,int[] nums, ArrayList<Integer> set, List<List<Integer>> result){
        if(length == 0){
            result.add((ArrayList<Integer>)set.clone());
            return;
        }
        for(int i = start ; i < nums.length; i++){
            set.add(nums[i]);
            utils(i+1,length - 1,nums,set,result);
            set.remove(set.size()-1);
        }
    }

    /**
    * concise solution
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        utils(0,nums,new ArrayList<Integer>(),result);
        return result;
    }
    
    private void utils(int start,int[] nums, ArrayList<Integer> set, List<List<Integer>> result){
        result.add(set);
        for(int i = start ; i < nums.length; i++){
            ArrayList<Integer> next = new ArrayList<>(set);
            next.add(nums[i]);
            utils(i+1,nums,next,result);
        }
    }
}