/**
 * https://leetcode.com/problems/powx-n/
 */
public class Solution {
	/**
	 * using recursion
	 */
    public double myPow(double x, int n) {
        return pow(x,n);
    }
    private double pow(double x, long n){
        if(n == 1) return x;
        if(n == 0 || x == 1 ) return 1;
        if(n < 0) return 1/pow(x,-n);
        double halfPow = pow(x,n/2);
        return (n%2 == 0) ? halfPow * halfPow : halfPow * halfPow * x;
    }
	/**
	 * iterative version
	 */
	public double myPow(double x, int n) {
       if(n == 1) return x;
       if(n == 0 || x == 1 ) return 1;
       double result = 1;
       long pow = Math.abs((long)n);
       while(pow > 0){
           if((pow & 1) == 1) result *= x;
           x*= x;
           pow >>= 1;
       }
        return n < 0 ? 1/result : result; 
    }
	
}