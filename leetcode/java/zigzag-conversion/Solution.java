/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        StringBuilder[] rows = new StringBuilder[numRows];
        int count = 0 ;
        boolean bottom = true;
        while(count < s.length()){
            if(bottom){
                int start = 0 ;
                while(start < numRows && count < s.length()){
                    if(rows[start] == null ) rows[start] = new StringBuilder();
                    rows[start].append(s.charAt(count));
                    count++;
                    start++;
                }
                bottom = !bottom;
            }else{
                int start = numRows - 2;
                while(start > 0 && count < s.length()){
                    if(rows[start] == null ) rows[start]  = new StringBuilder();
                    rows[start].append(s.charAt(count));
                    count++;
                    start--;
                }
                bottom = !bottom;
            }
        }
        for(StringBuilder row : rows)
            if(row != null) result.append(row.toString());
        return result.toString();
    }
}