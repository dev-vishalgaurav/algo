/**
 * https://www.interviewbit.com/problems/atoi/
 */
public class Solution {
	public int atoi(final String a) {
	    if(a == null || a.isEmpty()) return 0;
        int i = 0, j = a.length() - 1;
        while(i < j && a.charAt(i) == ' ') i++;
        while(j >= i && a.charAt(j) == ' ') j--;
        if(i > j) return 0; // no valid chars
        boolean isNve = (a.charAt(i) == '-' || a.charAt(i) == '+') ? a.charAt(i++) == '-' ? true : false : false;
        long num = 0;
        while(i <= j && a.charAt(i)!= '.'){
            char c = a.charAt(i++);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
                if(isNve && num >= Math.abs((long)Integer.MIN_VALUE)) return Integer.MIN_VALUE;
                else if(!isNve && num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }else break;
        }
        return (int)(num == 0 ? num : (isNve) ? -num : num) ;
	}
}
