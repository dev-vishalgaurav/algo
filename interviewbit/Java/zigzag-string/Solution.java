/**
 * https://www.interviewbit.com/problems/zigzag-string/
 */
public class Solution {
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
}