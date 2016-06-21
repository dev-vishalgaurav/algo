/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int count = 0 ; count < strs[0].length(); count++){
            for(int i = 1 ; i < strs.length ; i++){
                if(count >= strs[i].length() || strs[0].charAt(count) != strs[i].charAt(count))
                    return strs[0].substring(0, count);
            }
        }
        return strs[0];
    }
}