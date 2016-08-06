/**
 *https://www.interviewbit.com/problems/permutations/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		permute(0,a,result);
		return result;
	}
	private void permute(int start ,ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result){
		if( start == a.size()){
			result.add(new ArrayList<>(a));
			return;
		}
		for(int i = start; i < a.size(); i++){
			swap(a,i,start);
			permute(start+1, a, result);
			swap(a, i, start);
		}
	} 
	private void swap(ArrayList<Integer> num, int from, int to){
		Integer temp = num.get(from);
		num.set(from, num.get(to));
		num.set(to, temp);
	}
}
