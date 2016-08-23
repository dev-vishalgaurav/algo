/**
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int m = t.length(), n = s.length();
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0],1);
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(s.charAt(j) == t.charAt(i)){
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                }else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[m][n];
    }
}