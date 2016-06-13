/**
*https://leetcode.com/problems/one-edit-distance/
*/
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        boolean result = false;
        if (Math.abs(s.length() - t.length()) > 1)
            return result;
        int maxLength = t.length(), i = 0, j = 0;
        String smaller = s, longer = t;
        if (s.length() > t.length()) {
            smaller = t;
            longer = s;
            maxLength = s.length();
        }
        while (i < maxLength) {
            if (i < longer.length() && j < smaller.length()) {
                if (longer.charAt(i) != smaller.charAt(j)) {
                    if (result) 
                        return false;
                    else if(longer.length() != smaller.length()) {
                        result = true;
                        i++;
                        continue;
                    }else 
                        result = true;
                }
            } else {
                if (result) 
                    return false;
                else 
                    result = true;
            }
            i++; j++;
        }
        return result;
    }
}