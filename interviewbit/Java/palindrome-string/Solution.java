/**
 * https://www.interviewbit.com/problems/palindrome-string/
 */
public class Solution {
	public int isPalindrome(String a) {
	    a = a.toLowerCase();
        int i = 0, j = a.length() -1;
        while(i < j){
            char left = a.charAt(i), right = a.charAt(j);
            if(!((left >= 'a' && left <= 'z') || (left >= '0' && left <= '9'))) i++;
            else if(!((right >= 'a' && right <= 'z') || (right >= '0' && right <= '9'))) j--;
            else if(left != right) return 0;
            else {i++; j--;}
        }
        return 1;
	}
}
