/**
 * https://www.interviewbit.com/problems/subsets-ii/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
	    Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        find(a,0,new ArrayList<>(),result);
        return result;
	}
    private void find(ArrayList<Integer> nums, int start,ArrayList<Integer> trail,ArrayList<ArrayList<Integer>> result){
        result.add(trail);
        for(int i = start; i < nums.size(); i++){
            if(i > start && nums.get(i) == nums.get(i-1)) continue; // no need of this but still.. 
            ArrayList<Integer> next = new ArrayList<>(trail);
            next.add(nums.get(i));
            find(nums,i+1,next,result);
        }
    }
	private void find(ArrayList<Integer> nums, int start,ArrayList<Integer> trail,ArrayList<ArrayList<Integer>> result){
        result.add(new ArrayList<>(trail));
        for(int i = start; i < nums.size(); i++){
            if(i > start && nums.get(i) == nums.get(i-1)) continue; // no need of this but still..
            trail.add(nums.get(i));
            find(nums,i+1,trail,result);
            trail.remove(trail.size()-1);
        }
    }
}
