/**
 * https://leetcode.com/problems/unique-paths/ 
 */
public class Solution {
	/**
	 * Using Math (m+n-2) C (m -1)
	 */
    public int uniquePaths(int m, int n) {
        // (m + n - 2) C (m-1 )
        int max = m + n -2, min = Math.min(m,n) - 1;
        long res = 1;
        for(int i = 0 ; i < min ; i++){
            res = res * (max - i) / (i + 1);
        }
        return (int)res;
    }
	/**
	 * Using DP
	 */
	public int uniquePaths(int m, int n) {
        int[] layer = new int[n];
        layer[0] = 1;
        for(int i = 0 ; i < m ; i++)
            for(int j = 1 ; j < n ; j ++)
                layer[j] = layer[j-1] + layer[j];
        return layer[n-1];
    }
}