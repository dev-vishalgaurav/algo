/**
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    int slow, fast;
		for(slow = a.get(0), fast = a.get(a.get(0)) ;slow != fast ; slow = a.get(slow), fast = a.get(a.get(fast)) );
		for(fast = 0 ; slow != fast ; slow = a.get(slow), fast = a.get(fast));
		return slow; 
	}
	/**
	 * using while loop
	 */
	public int repeatedNumber(final List<Integer> a) {
	    int slow = a.get(0), fast = a.get(a.get(0));
	    while(slow != fast){
	        slow = a.get(slow);
	        fast = a.get(a.get(fast));
	    }
	    fast = 0;
	    while(slow != fast){
	         slow = a.get(slow);
	         fast = a.get(fast);
	    }
		return slow; 
	}
}
