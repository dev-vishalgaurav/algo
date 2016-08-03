/**
 * https://www.interviewbit.com/problems/count-element-occurence/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public int findCount(final List<Integer> a, int b) {
	    if( a == null || a.isEmpty()) return 0;
	    int left = bSearch(a,b,true);
	    if(left  != -1) return bSearch(a,b,false) - left + 1;
	    else return 0;
	}
	
	private int bSearch(List<Integer> a, int b, boolean isLower){
	    int lo = 0, hi = a.size() -1, mid = 0, result = -1;
	    while(lo <= hi){
	        mid = lo + (hi - lo)/2;
	        int midVal = a.get(mid);
	        if( midVal == b){
	            result = mid;
	            if(isLower) hi = mid - 1;
	            else lo = mid + 1;
	        }else if(midVal > b) hi = mid - 1;
	         else lo = mid + 1;
	    }
	    return result;
	}
}
