/**
 * https://www.interviewbit.com/problems/longest-palindromic-substring/
 */
public class Solution {
	public String longestPalindrome(String s) {
	    if(s == null || s.isEmpty()) return "";
	    int[] ij = {0,-1};    
        for(int i = 0 ; i < s.length(); i++){
            int[] len = expandAroundCenter(s,i,i+1);
            ij = (len[1] - len[0] > ij[1] - ij[0]) ? len : ij; 
            len = expandAroundCenter(s,i,i);
            ij = (len[1] - len[0] > ij[1] - ij[0]) ? len: ij; 
        }
        return s.substring(ij[0], ij[1] + 1);
	}
    private int[] expandAroundCenter(String s, int i, int j){
        int[] result = {i,i};
        while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            result[0] = i--;
            result[1] = j++;
        }
        return result;
    }
}
