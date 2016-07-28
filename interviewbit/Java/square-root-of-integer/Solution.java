/**
 * https://www.interviewbit.com/problems/square-root-of-integer/
 */1
public class Solution {
	public int sqrt(int num) {
	    if(num < 0) return 0;
        if(num == 0 || num == 1) return num;
        int lo  = 1, hi = num/2;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2, cur = num / mid, next = num / (mid + 1);
            if(mid <= cur && mid+1 > next) return mid;
            else if(mid > cur) hi = mid - 1;
            else lo = mid + 1;
        }
        return 0;        
	}
}
