/**
 * https://www.interviewbit.com/problems/count-and-say/
 */
public class Solution {
	public String countAndSay(int n) {
	    if( n <= 1) return "1";
        String prev = countAndSay(n-1);
        int i = 0 , len = prev.length(), j = 0;
        StringBuilder sb = new StringBuilder();
        while( i< len){
            char cur = prev.charAt(i);
            int count = 1;
            while( i + 1 < len && prev.charAt(i+1) == cur){ 
                i++;
                count++;
            }
            i++;
            sb.append(count).append(cur);
        }
        return sb.toString();
	}
}
