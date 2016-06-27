/**
 * https://leetcode.com/problems/integer-break/
 */
public class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int mod = n % 3, div = n / 3, rem = 1;
        if(mod == 1){
            div--;
            rem = 4;
        }else if(mod == 2){
            rem = 2;
        }
        return (int)Math.pow(3,div) * rem;
    }
}