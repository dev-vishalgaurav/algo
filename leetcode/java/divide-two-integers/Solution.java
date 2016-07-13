/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class Solution {

    public int divide(int dividend, int divisor) {
		
        boolean isPve = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));
        long dividendl = Math.abs((long)dividend), divisorl = Math.abs((long)divisor);
        if(divisorl == 0) return Integer.MAX_VALUE;
        if(dividendl == 0 || dividendl < divisorl) return 0;
        long count = divide(dividendl,divisorl);
        if(count > Integer.MAX_VALUE)
              return isPve ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        return  (int) (isPve ? count : - count);
    }
	
    private long divide(long dividendl, long divisorl ){
        if(dividendl < divisorl ) return 0;
        long count = 1, num = divisorl;
        while(num << 1 <= dividendl){
            count <<= 1;
            num <<= 1;
        }
        return count + divide(dividendl - num, divisorl); // recursion is important to decrease the complexity
    }
}