/**
 *https://leetcode.com/problems/shortest-word-distance-iii/
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE, p1 = words.length, p2 = -words.length;
        boolean isEqual = word1.equals(word2);
        for(int i = 0 ; i < words.length ; i++){
            if(isEqual && word1.equals(words[i])){
                if(p1 == words.length)
                    p1 = i;
                else{
                    result = Math.min(result, i - p1);
                    p1 = i;
                }
                continue;
            }else if(word1.equals(words[i])){
                p1 = i;
            }else if(word2.equals(words[i])){
                p2 = i;
            }
            result = Math.min(result, Math.abs(p2 - p1));
        }
        return result;
    }
	/**
	* improved solution beats 84% 2 ms runtime
	*/
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE, p1 = words.length, p2 = -words.length;
        boolean isEqual = word1.equals(word2);
        if(isEqual){
            for(int i = 0 ; i < words.length ; i++){
                if(word1.equals(words[i])){
                    if(p1 == words.length){
                        p1 = i;
                    }else{
                        result = Math.min(result, i - p1);
                        p1 = i;
                    }
                }
            }
            return result;
        }
        for(int i = 0 ; i < words.length ; i++){
            if(word1.equals(words[i])){
                p1 = i;
            }else if(word2.equals(words[i])){
                p2 = i;
            }else continue;
            result = Math.min(result, Math.abs(p2 - p1));
        }
        return result;
    }
}