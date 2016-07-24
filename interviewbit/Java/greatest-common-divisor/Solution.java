 /**
 * https://www.interviewbit.com/problems/greatest-common-divisor/
 */
public class Solution {
	public int gcd(int a, int b) {
	    if(b == 0) return a;
	    return  a % b == 0 ? b : gcd(b,a%b);
	}
}
