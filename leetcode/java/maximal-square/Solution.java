/**
 * https://leetcode.com/articles/maximal-square/
 */
public class Solution {
    /**
     * https://discuss.leetcode.com/topic/15328/easy-dp-solution-in-c-with-detailed-explanations-8ms-o-n-2-time-and-o-n-space/3
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, len = 0, pre = 0;
        int[] dp = new int[n+1]; // dp for horizaontal and vartical columns
        for(int i = 1 ; i <= m ; i++)
            for(int j = 1 ; j <= n ; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                   dp[j] = Math.min(dp[j],Math.min(dp[j-1],pre)) + 1 ;
                   len = Math.max(len,dp[j]);
                }else 
                    dp[j] = 0;
                pre = temp;
            }
        return len*len;
    }
}