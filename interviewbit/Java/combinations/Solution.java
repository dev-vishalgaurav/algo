/**
 *https://www.interviewbit.com/problems/combinations/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        find(1,n,k,new ArrayList<>(),result);
        return result;
	}
	private void find(int start, int n, int k, ArrayList<Integer> trail,ArrayList<ArrayList<Integer>> result){
        if(k == 0){
            result.add(new ArrayList<>(trail));
            return;
        }
        for(int i = start ; i <= n; i++){
            trail.add(i);
            find(i+1,n,k-1,trail,result);
            trail.remove(trail.size()-1);
        }
    }
}
