/**
 * https://www.interviewbit.com/problems/length-of-last-word/
 */
public class Solution {
	public int lengthOfLastWord(final String a) {
	    if(a == null || a.isEmpty()) return 0;
        int j = 0, i = a.length() - 1;
        while(i >= 0 && a.charAt(i) == ' ') i--;
        for(j = i ; j >= 0 ; j--){
            if(a.charAt(j) == ' ') return i - j;
        }
        return i - j;
	}
}
