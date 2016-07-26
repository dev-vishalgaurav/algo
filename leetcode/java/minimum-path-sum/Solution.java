/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Solution {
    public int minPathSum(int[][] grid) {
       if(grid.length == 0 || grid[0].length == 0) return 0;
    	int m = grid.length, n = grid[0].length;
    	int[] dp = new int[n];
    	dp[0] = grid[0][0];
    	for(int i = 0 ; i < m ; i++)
    		for(int j = 0 ; j < n ; j++){
    			if(i == 0 && j == 0) continue;
    			int top = (i > 0) ? dp[j] : Integer.MAX_VALUE;
    			int left = (j > 0) ? dp[j-1] : Integer.MAX_VALUE;
    			dp[j] = grid[i][j] + Math.min(top, left);
    		}
    	return dp[n-1];        
    }
}