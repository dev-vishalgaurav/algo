/**
 * https://www.interviewbit.com/problems/divide-integers/
 */
public class Solution {
	/**
	 * Iterative version
	 */
	public int divide(int dividend, int divisor) {
	    boolean isPve = dividend < 0 ^ divisor < 0 ? false : true;
        long q = 0, ddl = Math.abs((long)dividend), drl = Math.abs((long)divisor);
        for(long t = 0, i = 31 ; i >= 0 ; i--){
            if( t  + (drl << i) <= ddl){
                 t += drl << i;
                 q |= 1l << i;
            }
        }
        q = isPve ? q : -q;
        return (int)(Integer.MIN_VALUE <= q && q <= Integer.MAX_VALUE ? q : Integer.MAX_VALUE );
	}
	public int divide(int dividend, int divisor) {
	    boolean isPve = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));
        long dividendl = Math.abs((long)dividend), divisorl = Math.abs((long)divisor);
        if(divisorl == 0) return Integer.MAX_VALUE;
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
        return count + divide(dividendl - num, divisorl);
    }
}
