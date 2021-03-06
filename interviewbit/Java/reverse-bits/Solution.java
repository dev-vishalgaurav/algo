/**
 * https://www.interviewbit.com/problems/reverse-bits/
 */
public class Solution {
	public long reverse(long n) {
	    long r = 0;
        for(int i = 0 ; i < 32 ; i++){
            r <<= 1;
            r += (n & 1);
            n >>= 1;
        }
        return r;
	}
}
