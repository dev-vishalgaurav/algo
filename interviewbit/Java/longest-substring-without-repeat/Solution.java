/**
 * https://www.interviewbit.com/problems/longest-substring-without-repeat/
 */
public class Solution {
	public int lengthOfLongestSubstring(String a) {
	   int i = 0, j = 0, len = 0;
        boolean[] set = new boolean[256];
        while(i <= j && j < a.length()){
            if(set[a.charAt(j)]){
                set[a.charAt(i++)] = false;
            }else{
                set[a.charAt(j++)] = true;
                len = Math.max(j-i,len);
            }
        }
        return len;
	}
}
