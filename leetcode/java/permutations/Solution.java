/**
 * https://leetcode.com/problems/permutations/
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null || nums.length == 0) return result;
        find(0,nums,new ArrayList<>(), result);
        return result;
    }
    
    private void find(int start, int[] nums, List<Integer> trail,List<List<Integer>> result){
        if(start == nums.length){
            result.add(new ArrayList<>(trail));
            return;
        }
        for(int i = start ; i < nums.length ; i++){
            swap(nums,i,start);
            trail.add(nums[start]); // start s fixed now
            find(start+1,nums,trail,result);
            trail.remove(trail.size()-1);
            swap(nums,i,start); // backtrack
        }
    }
    private void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}