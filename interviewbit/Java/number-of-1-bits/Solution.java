/**
 *https://www.interviewbit.com/problems/number-of-1-bits/
 */
 public class Solution {
	public int numSetBits(long num) {
	    int count = 0;
        while(num != 0){
            if((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
	}
}
