/**
 * https://www.interviewbit.com/problems/stairs/
 */
public class Solution {
	public int climbStairs(int n) {
	    int first = 1, second = 2;
	    if(n <= 0) return 0;
	    if(n == 1) return first;
	    if(n == 2) return second;
	    for(int i = 3 ; i <= n ; i++){
	        int temp = second;
	        second = first + second;
	        first = temp;
	    }
	    return second;
	}
}
