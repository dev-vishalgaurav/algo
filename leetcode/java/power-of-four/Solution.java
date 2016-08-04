public class Solution {
	/**
	 * https://leetcode.com/problems/power-of-four/
	 */
    public boolean isPowerOfFour(int n) {
       if(n <=0 || (n & n-1) != 0 ) return false;
       int count = 0;
       for(;n!=1;count++,n >>= 1);
       return (count & 1) == 0;
    }
	public boolean isPowerOfFour(int n) {
       if(n > 0 && (n & n-1) == 0){
           int count = 0;
           while(n != 1){ 
               n >>= 1;
               count++;
           }
           return (count & 1) == 0;
       }
       return false;
    }
}