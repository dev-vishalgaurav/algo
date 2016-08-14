/**
 * https://www.interviewbit.com/problems/combination-sum/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(a);
        find(a,0,b,new ArrayList<>(),result);
        return result;
	}
	private void find(ArrayList<Integer> nums, int start, int target, ArrayList<Integer> trail, ArrayList<ArrayList<Integer>> result){
        if(target < 0) return ;
        if(target == 0){
            result.add(new ArrayList<>(trail));
            return;
        }
        for(int i = start ; i < nums.size() ; i++){
            if(i > start && nums.get(i-1) == nums.get(i)) continue; // avoid duplicate
            trail.add(nums.get(i));
            find(nums,i,target - nums.get(i),trail,result);
            trail.remove(trail.size()-1);
        }
    }
}
