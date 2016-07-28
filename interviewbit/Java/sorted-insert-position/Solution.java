/**
 * https://www.interviewbit.com/problems/sorted-insert-position/
 */
public class Solution {

	public int searchInsert(ArrayList<Integer> a, int target) {
	   int lo = 0, hi = a.size()-1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(target == a.get(mid)) return mid;
            else if(target < a.get(mid)) hi = mid -1;
            else lo = mid + 1;
        }
        return lo;
	}
	public int searchInsert(ArrayList<Integer> a, int target) {
	   int lo = 0, hi = a.size(), mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(a.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
		return lo;
	}
}
