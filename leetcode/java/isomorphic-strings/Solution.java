/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Solution {
	/**
	 * using Sinlge HashMap
	 */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<String,Integer> mapS = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
			// this is tricky. Put returns null or previous value and Objects.equals takes care of null.
            if(!Objects.equals(mapS.put("$"+sc,i), mapS.put("#"+tc,i))) 
				return false;
        }
        return true;
    }
	/**
	 * using Arrays to increase speed. 
	 */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
		    if(mapS[sc] != mapT[tc]) 
		        return false;
		    mapS[sc] = mapT[tc] = i + 1;
        }
        return true;
    }
}
