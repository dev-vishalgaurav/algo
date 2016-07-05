/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.isEmpty() || k==0) return 0;
        int len = 1, i = 0 , j = 1, size = 1;
        int[] set = new int[256];
        set[s.charAt(i)]++;
        while(j < s.length()){ // i is always less than j
            char cur = s.charAt(j);
            if(set[cur]!=0){
                set[cur]++;
                len = Math.max(len,j-i+1);
                j++;
            }else if (size == k){
                char curI = s.charAt(i);
                set[curI]--;
                if(set[curI] == 0){
                    j++;
                    set[cur]++;
                }
                i++;
            }else{// size < 2
                set[cur]++;
                len = Math.max(len,j-i+1);
                j++;
                size++;
            }
        }
        return len;   
    }
}