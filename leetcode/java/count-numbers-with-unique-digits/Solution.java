/**
* https://leetcode.com/problems/count-numbers-with-unique-digits/
*/
public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if(n <= 0) return 1;
        if(n == 1 ) return 10;
        if(n == 2) return 91;
        n = Math.min(10,n);
        int fact = 81, dp = 91;
        for(int i = 3 ; i <= n ; i++){
            fact *= (11 - i);
            dp += fact  ;
        }
        return dp;
    }
}