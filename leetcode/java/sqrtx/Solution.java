/**
* https://leetcode.com/problems/sqrtx/
*/
public class Solution {
	/**
	 * by using long to prevent overflow
	 */
    public int mySqrt(int num) {
        if(num < 0) return 0;
        if(num == 0 || num == 1) return num;
        int lo  = 1, hi = num/2;
        while(lo <= hi){
            long mid = lo + (hi - lo)/2;
            long next = (mid + 1) * (mid + 1), cur = mid * mid;
            if(cur == num || (next > num && cur < num )) return (int)mid;
            else if(cur > num) hi = (int)mid - 1;
            else lo = (int) mid + 1;
        }
        return 0;        
    }
	 /**
	  * using division technique
      * mid*mid <= x
      * mid <= x/mid  // for the overflow
      */
    public int mySqrt(int num) {
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