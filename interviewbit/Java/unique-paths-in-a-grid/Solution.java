/**
 * https://www.interviewbit.com/problems/unique-paths-in-a-grid/
 */
public class Solution {
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> grid) {
	    if(grid == null || grid.isEmpty() || grid.isEmpty() ) return 0;
        int m = grid.size(), n = grid.get(0).size();
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int num = grid.get(i).get(j);
                if(num == 1) dp[j+1] = 0;
                else dp[j+1] = dp[j+1] + dp[j];
            }
            dp[0] = 0;
        }
                
        return dp[n];
	}
}
