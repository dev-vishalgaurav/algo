/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        find(nums,new boolean[nums.length],new ArrayList<>(), result);
        return result;
    }
    private void find(int[] nums,boolean[] used, List<Integer> trail,List<List<Integer>> result){
        if(trail.size() == nums.length){
            result.add(new ArrayList<>(trail));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            trail.add(nums[i]); // start s fixed now
            find(nums,used,trail,result);
            trail.remove(trail.size()-1);
            used[i] = false;
        }
    }
}