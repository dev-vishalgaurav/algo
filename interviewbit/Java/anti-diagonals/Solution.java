/**
 * https://www.interviewbit.com/problems/anti-diagonals/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a == null || a.isEmpty()) return result;
        int n = a.get(0).size();
        // 1st half 
        for(int k = 0 ; k < n ; k++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int i = 0, j = k ; i < n && j >= 0 ; i++, j-- ){
                row.add(a.get(i).get(j));
            }
            result.add(row);
        }
        for(int k = 1 ; k < n ; k++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int i = k, j = n-1 ; i < n && j >= 1 ; i++, j-- ){
                row.add(a.get(i).get(j));
            }
            result.add(row);
        }
        
        return result;

	}
}
