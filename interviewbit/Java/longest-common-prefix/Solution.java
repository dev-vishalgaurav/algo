/**
 * https://www.interviewbit.com/problems/longest-common-prefix/
 */
public class Solution {
	public String longestCommonPrefix(ArrayList<String> strs) {
	   if(strs == null || strs.isEmpty()) return "";
        for(int count = 0 ; count < strs.get(0).length(); count++){
            for(int i = 1 ; i < strs.size() ; i++){
                if(count >= strs.get(i).length() || strs.get(0).charAt(count) != strs.get(i).charAt(count))
                    return strs.get(0).substring(0, count);
            }
        }
        return strs.get(0);
	}
}
