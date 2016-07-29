/**
 * https://www.interviewbit.com/problems/single-number/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int result = 0;
	    for(int num : a) result ^= num;
	    return result;
	}
}
