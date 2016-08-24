/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int num = grid[i][j];
                if(num == 1) dp[j+1] = 0;
                else dp[j+1] = dp[j+1] + dp[j];
            }
            dp[0] = 0;
        }
                
        return dp[n];
    }
}