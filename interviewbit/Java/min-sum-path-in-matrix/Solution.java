/**
 * https://www.interviewbit.com/problems/min-sum-path-in-matrix/
 */
public class Solution {
	public int minPathSum(ArrayList<ArrayList<Integer>> grid) {
	    if(grid == null || grid.isEmpty() || grid.get(0).isEmpty()) return 0;
        int m = grid.size(), n = grid.get(0).size();
        int[] dp = new int[n];
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++){
                int cur = grid.get(i).get(j);
                if(i > 0 && j > 0) dp[j] = Math.min(dp[j],dp[j-1]) + cur;
                else if(i > 0 && j == 0) dp[j] = cur + dp[j];
                else if(j > 0 && i == 0) dp[j] = cur + dp[j-1];
                else   dp[j] = cur;
            }
        return dp[n-1];
	}
}
