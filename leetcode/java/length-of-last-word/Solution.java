/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int start = s.length() - 1;
        while(start > 0 && s.charAt(start) == ' ') start--;
        for( int i = start ; i >= 0 ; i--){
            if(s.charAt(i) == ' ')
                return start - i;
        }
        return start + 1;
    }
	public int lengthOfLastWord(String a) {
        if(a == null || a.isEmpty()) return 0;
        int streak = 0, len = a.length(), result = 0 ;
        for(int i =  0 ; i < len ; i++){
            streak = a.charAt(i) == ' ' ? 0 : streak + 1;
            result = streak > 0 ? streak : result;
        }
        return result;
    }
}