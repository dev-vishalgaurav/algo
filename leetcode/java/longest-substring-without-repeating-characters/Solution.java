/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    /**
     * Sliding window O(n) but slow.
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int length = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int i = 0 , j = 0 ;
        while(j < s.length()){
            if(set.contains(s.charAt(j))){
                set.clear();
                i++;
                j=i;
            }else{
                set.add(s.charAt(j));
                length = Math.max(length,j - i + 1);
                j++;
            }
        }
        return length;
    }
    /**
     * https://leetcode.com/articles/longest-substring-without-repeating-characters/
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int length = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int i = 0 , j = 0 ;
        while(i<= j && j < s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else{
                set.add(s.charAt(j++));
                length = Math.max(length,j - i);
            }
        }
        return length;
    }
    /**
     * Same as above using array instead of HashSet, Beats 93% submissions
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int length = Integer.MIN_VALUE;
        boolean[] set = new boolean[256];
        int i = 0 , j = 0 ;
        while(i<= j && j < s.length()){
            if(set[s.charAt(j)]){
                set[s.charAt(i++)] = false ;
            }else{
                set[s.charAt(j++)] = true;
                length = Math.max(length,j - i);
            }
        }
        return length;
    }
    /**
     * Most efficient solution. 
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int length = Integer.MIN_VALUE, n = s.length();
        int[] set = new int[256];
        for(int i = 0 , j = 0 ; j < n ; j++){
            i = Math.max(i,set[s.charAt(j)]);
            length = Math.max(length, j - i +1);
            set[s.charAt(j)] = j + 1;
        }
        return length;
    }
}