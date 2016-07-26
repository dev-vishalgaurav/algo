/**
 * https://leetcode.com/problems/dungeon-game/
 */
public class Solution {
    public int calculateMinimumHP(int[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    	int m = grid.length, n = grid[0].length;
    	int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1] = dp[n] = 1; // base case;
        for(int i = m-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j-- ){
                int min = Math.min(dp[j+1],dp[j]) - grid[i][j];
                dp[j] = min <= 0 ? 1 : min; // knight will die even when 0
            }
            dp[n] = Integer.MAX_VALUE; // forcing no minimum after right wall.
        }
    	return dp[0];
    }
}