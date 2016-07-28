/**
 * https://www.interviewbit.com/problems/search-for-a-range/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int target) {
	    int left = search(a,target);
        if(left == a.size() || a.get(left) != target) return new ArrayList<>(Arrays.asList(new Integer[]{-1,-1}));
        return new ArrayList<>(Arrays.asList(new Integer[]{left,search(a,target+1) - 1}));
	}
	private int search(List<Integer> a, int target){
        int lo = 0, hi = a.size(), mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(a.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
