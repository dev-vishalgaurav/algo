/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int count = 0;
        while(count < strs[0].length()){
            char cur = strs[0].charAt(count);
            for(int i = 1 ; i < strs.length ; i++){
                if(count >= strs[i].length() || cur != strs[i].charAt(count))
                    return strs[0].substring(0, count);
            }
            count++;
        }
        return strs[0].substring(0, count);
    }
}