/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Solution {
	public int myAtoi(String a) {
        if(a == null || a.isEmpty()) return 0;
        int i = 0, j = a.length() - 1;
        while(i < j && a.charAt(i) == ' ') i++; // trim spaces in front
        while(j >= i && a.charAt(j) == ' ') j--; // trin spaces from back
        if(i > j) return 0; // no valid chars
		// check the first char for ngeative or positive chars else default is false;
        boolean isNve = (a.charAt(i) == '-' || a.charAt(i) == '+') ? a.charAt(i++) == '-' ? true : false : false;
        long num = 0;
        while(i <= j && a.charAt(i)!= '.'){
            char c = a.charAt(i++);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
                if(isNve && num >= Math.abs((long)Integer.MIN_VALUE)) return Integer.MIN_VALUE;
                else if(!isNve && num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }else break; // invalid string found return the num 
        }
        return (int)(num == 0 ? num : (isNve) ? -num : num) ;
    }
    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()) return 0;
        boolean isNegative = str.charAt(0) == '-';
        int start = (isNegative) ? 1 : str.charAt(0) == '+' ? 1 : 0 ;
        int end = start + 1;
        while(end < str.length() && str.charAt(end) != '.' && isNumeric(str.charAt(end)))
            end++;
        end--;
        long number = 0;
        int count = end;
        int power = 0;
        while(count >= start && count < str.length() && !isNumeric(str.charAt(count)))
            count--;
        int checkCount = start;
        while(checkCount <str.length() && checkCount <= count ){
             if(!isNumeric(str.charAt(checkCount)))
                return 0;
            checkCount++;
        }
        while(count < str.length() && count >= start){
            char curr = str.charAt(count);
            if(isNumeric(curr)){
                int curDigit = curr - '0';
                long currentVal = (int) Math.pow(10, power) * ( curDigit );
                number += currentVal;
                if(power > 8){
                    if(isNegative && -1 * number <= Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                    else if(!isNegative && number >= Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                }
                count--;
                power++;
            }else{
                return 0;
            }
        }
        return (isNegative)  ? (int) (number * -1) :  (int) number;
    }
    private boolean isNumeric(char c){
        return c >= '0' && c <= '9';
    }
}