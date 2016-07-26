/**
 *https://www.interviewbit.com/problems/reverse-integer/
 */
public class Solution {
	public int reverse(int x) {
	   int rev = 0;
        while(x != 0){
            if((rev*10) / 10 != rev) return 0;
            rev = rev*10 + x % 10;
            x = x/10;
        }
        return rev;
	}
}
