/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int ri = -1, rj = -1 , right = 0, left = 0, count = t.length(), min = Integer.MAX_VALUE;
        for(int i = 0 ; i < t.length(); i++) 
            map[t.charAt(i)]++; // update the map with t
        while(left < s.length()){
            if(map[s.charAt(left)] > 0) 
                count--; // current character is a part of the substring
            map[s.charAt(left)]--;
            left++;
            while(count == 0){ // if count is 0 it means the substring is found.
                // now update the window
                if(left - right < min){
                    rj = left;
                    ri = right;
                    min = left - right;
                }
                map[s.charAt(right)]++;
                if (map[s.charAt(right)] > 0) // it means right is leaving the character which is part of the window
				    count++;
				right++;
            }
        }
        return (ri == -1 || rj == -1) ? "" : s.substring(ri,rj);
    }
}