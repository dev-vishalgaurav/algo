/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        /**
         *By using Brian Kernighan's Algorithm
         * N & (N-1) will turn off the first set bit.
         */
        while(n > m){
            n &= (n-1);
        }
        return n & m;
    }
}