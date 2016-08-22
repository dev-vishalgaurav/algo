/**
 * https://www.interviewbit.com/problems/ways-to-decode/
 */
public class Solution {
	public int numDecodings(String s) {
	    if(s == null || s.isEmpty()) return 0;
        if(s.charAt(0) == '0') return 0;
        int prev = 1, cur = 1;
        for(int i = 1 ; i < s.length() ; i++){
            char c1 = s.charAt(i), c2 = s.charAt(i-1); // c1 = current and c2 = previous
            if(!(Character.isDigit(c1) && Character.isDigit(c2))) 
                return 0; // invalid
            if(c1 == '0' && c2 == '0') 
                return 0; // not valid
            if(c1 == '0' && c2 >= '3') 
                return 0;
            if(c1 == '0' || c2 == '0'){
                cur = prev ;
            }else if(c2 == '1' || (c2 == '2' && c1 <= '6') ){
                int temp = cur;
                cur = prev + cur;
                prev = temp;
            }else
                prev = cur;
        }
        return cur;
	}
}
