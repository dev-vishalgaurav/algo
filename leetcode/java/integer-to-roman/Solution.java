/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Solution {
	public String intToRoman(int a) {
	    return intToRoman(a,new StringBuilder()).toString();
	}
	private StringBuilder intToRoman(int num, StringBuilder sb){
        if(num <= 0) return sb;
        if(num >= 1000) return intToRoman(num - 1000,sb.append("M"));
        if(num >= 900) return intToRoman(num - 900,sb.append("CM"));
        if(num >= 500) return intToRoman(num - 500,sb.append("D"));
        if(num >= 400) return intToRoman(num - 400,sb.append("CD"));
        if(num >= 100) return intToRoman(num - 100,sb.append("C"));
        if(num >= 90) return intToRoman(num - 90,sb.append("XC"));
        if(num >= 50) return intToRoman(num - 50,sb.append("L"));
        if(num >= 40) return intToRoman(num - 40,sb.append("XL"));
        if(num >= 10) return intToRoman(num - 10,sb.append("X"));
        if(num >= 9) return intToRoman(num - 9,sb.append("IX"));
        if(num >= 5) return intToRoman(num - 5,sb.append("V"));
        if(num >= 4) return intToRoman(num - 4,sb.append("IV"));
        if(num >= 1) return intToRoman(num - 1,sb.append("I"));
        return sb;
    }
	
	public String intToRoman(int num) {
	   // 1000, 2000, 3000
        String[] M = {"", "M", "MM", "MMM"};
        // 100, 200, 300, .. 900
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 10, 20, ... 90
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 1, 2, ... 9
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
}
