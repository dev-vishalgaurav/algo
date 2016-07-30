/**
 * https://www.interviewbit.com/problems/single-number-ii/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int x1 = 0, x2 = 0, mask = 0;
	    for(int num : a){
	        x2 ^= x1&num;
	        x1 ^= num;
	        mask = ~(x1 & x2);
	        x2 &= mask;
	        x1 &= mask;
	    }
	    return x1;
	}
}
