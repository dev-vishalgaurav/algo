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
	public String reverseWords(String s) {
        String[] result = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = result.length - 1 ; i >=0 ; i--){
            if(!result[i].isEmpty()){
             sb.append(result[i]);
             sb.append(i == 0  ? "" :" " );
            }
        }
        return sb.toString();
    }