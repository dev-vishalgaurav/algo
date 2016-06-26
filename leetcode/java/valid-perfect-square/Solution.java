/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        if( num <= 0) return false;
        int sqrt = sqrt(num);
        return sqrt*sqrt == num;
    }
    
    private int sqrt(int num){
        int low = 0, high = num/2;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int multi = mid * mid ;
            int multi1 = (mid + 1) * (mid + 1);
            if(multi <= num && multi1 > num){
                return mid;
            }else if(multi < 0 || multi > num){ // less than 0 for overflow
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return 1;
    }
    
}