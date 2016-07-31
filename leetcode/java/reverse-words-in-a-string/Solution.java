/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' ') i--;
            if( i < 0) break;
            if(sb.length() > 0 ) sb.append(" ");
            String word = "";
            while(i >= 0 && s.charAt(i) != ' '){
                word = s.charAt(i) + word;
                i--;
            }
            sb.append(word);
        }
        return sb.toString();
    }
}