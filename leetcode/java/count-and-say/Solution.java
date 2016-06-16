/**
 * https://leetcode.com/problems/count-and-say/ 
 */
public class Solution {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        String previous = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int count = 0 ;
        while(count < previous.length()){
            char cur = previous.charAt(count);
            int start = count + 1, total = 1;
            while(start < previous.length() && previous.charAt(start) == cur){
                total++;
                start++;
            }
            count = start;
            result.append(""+ total + cur);
        }
        return result.toString();
    }
}