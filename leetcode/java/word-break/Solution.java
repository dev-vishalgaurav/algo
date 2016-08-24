/**
 * https://leetcode.com/problems/word-break/
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.isEmpty()) return false;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; // empty string
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}