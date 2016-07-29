/**
 * https://www.interviewbit.com/problems/implement-power-function/
 */
 
 public class Solution {
	public int pow(int xi, int n, int d) {
        long x = xi , result = 1, pow = Math.abs((long)n);;
        if(n == 0 && x == 0) return 0;
        if(n == 0 || x == 1 ) return 1;
        while(pow > 0){
            if((pow & 1) == 1) result = (result * x) % d ;
            x = (x * x) % d;
            pow >>= 1;
        }
         return (int)(n < 0 ? 0 : (result + d)  % d); 
	}
}
