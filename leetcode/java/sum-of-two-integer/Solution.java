/**
* https://leetcode.com/problems/sum-of-two-integers/
*/
public class Solution {
	/**
	* Iterative solution
	*/
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a^b;
            b = carry << 1;
        }
     return a;   
    }
    /**
     * Recursive solution
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b) << 1 );
    }
}