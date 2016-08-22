/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int result = 0 , m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n+1], stack = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            int top = 0, area = 0, k = 0;
            for(int j = 0 ; j < n ; j++)
                dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
            // now calculate the max rect area for an array. 
            while(k < dp.length){ // dp.length == n + 1
                if(top == 0 || dp[stack[top-1]] <= dp[k]) 
                    stack[top++] = k++; // push index to stack
                else{
                    int tp = stack[--top];
                    area = Math.max(area, dp[tp] * (top == 0 ? k : k - 1 - stack[top-1]));
                }
            }
            result = Math.max(result,area);
        }
        return result;
    }
}	