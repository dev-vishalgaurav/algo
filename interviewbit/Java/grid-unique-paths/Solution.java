/**
 * https://www.interviewbit.com/problems/grid-unique-paths/
 */
public class Solution {
	public int uniquePaths(int a, int b) {
	    // (a + b - 2) C (a-1 )
        int max = a + b - 2, min = Math.min(a,b) - 1;
        long res = 1;
        for(int i = 0 ; i < min ; i++){
            res = res * (max - i) / (i + 1);
        }
        return (int)res;
	}
}
	