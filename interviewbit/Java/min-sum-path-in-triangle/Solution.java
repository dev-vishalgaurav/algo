/**
 * https://www.interviewbit.com/problems/min-sum-path-in-triangle/
 */
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
	    if(a == null || a.isEmpty()) return 0;
        int len = a.size();
        List<Integer> dp = a.get(len - 1);
        for(int i = len - 2 ; i >= 0 ; i--){
            List<Integer> row = a.get(i);
            for(int j = 0 ; j < row.size() ; j++){
                dp.set(j,Math.min(dp.get(j),dp.get(j+1)) + row.get(j));
            }
        }
        return dp.get(0);
	}
}
