/**
 * https://www.interviewbit.com/problems/excel-column-number/
 */
public class Solution {
	public int titleToNumber(String a) {
	    if(a == null || a.isEmpty()) return 0;
        char base = 'A' - 1;
        long value = 0;
        for(char num : a.toCharArray()){
           value = value * 26 + (num - base);
        }
        return (int)value;
	}
}
