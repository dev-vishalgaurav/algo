/**
 * https://leetcode.com/problems/word-pattern/
 */
public class Solution {
	/**
	 * 
	 */
    public boolean wordPattern(String pattern, String str) {
        if(pattern.isEmpty() || str.isEmpty()) return false;
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        HashMap<String,Character> map = new HashMap<String,Character>();
        for(int i = 0 ; i < pattern.length() ; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(words[i])){
                if(map.get(words[i]) != c ) return false;
            }else if(!set[c-'a']){
                map.put(words[i],c);
                set[c-'a'] = true;
            }else{
                return false;
            }
        }
        return true;
    }
	/**
	 * Using 1 HashMap. 
	 */
	public boolean wordPattern(String pattern, String str) {
        if(pattern.isEmpty() || str.isEmpty()) return false;
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        HashMap<String,Integer> mapS = new HashMap<>();
        for(int i = 0 ; i < pattern.length() ; i++){
            char c = pattern.charAt(i);
			// this is tricky. Put returns null or previous value and Objects.equals takes care of null.
            if(!Objects.equals(mapS.put(words[i],i), mapS.put("#"+c,i))) 
				return false;
        }
        return true;
    }
}