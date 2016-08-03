/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class Solution {
	/**
	 * adding shorter solution
	 */
	public String convert(String s, int numRows) {
        if(numRows <= 1 || s == null || s.isEmpty() ) return s; 
        String result = "";
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows; rows[i] = new StringBuilder(), i++);
        int row = 0, n = s.length(), inc = 1;
        for(int i = 0 ; i < n ; i++){
            rows[row].append(s.charAt(i));
            if(row == 0) inc = 1;
            if(row == numRows - 1) inc = -1;
            row += inc;
        }
        for(StringBuilder sb : rows) result += sb;
        return result;
    }
	
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