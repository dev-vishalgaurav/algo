/**
 * https://www.interviewbit.com/problems/implement-power-function/
 */
 
 public class Solution {
	public int pow(int xi, int n, int d) {
        long x = xi,result = 1;;
        if(n == 0 && x == 0) return 0;
        if(n == 0 || x == 1 ) return 1;
        
        long pow = Math.abs((long)n);
        while(pow > 0){
            if((pow & 1) == 1) result = ((result % d) * (x % d)) % d ;
            x = ((x% d) * (x% d)) % d;
            pow >>= 1;
        }
         return (int)(n < 0 ? 0 : (result + d)  % d); 
	}
}
