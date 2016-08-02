/**
 * https://www.interviewbit.com/problems/excel-column-title/
 */
public class Solution {
	public String convertToTitle(int n) {
	   String result = "";
        char[] map = {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
        while(n > 0 ){
        	result =   map[n % 26] + result ;
	        n = --n / 26; // minimum is 1 not 0. Hence --n is required
        } 
        return result;
	}
}
