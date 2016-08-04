/**
 * https://www.interviewbit.com/problems/multiply-strings/
 */
public class Solution {
	public String multiply(String num1, String num2) {
	    if(num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) return "";
        int n1 = num1.length(), n2 = num2.length();
        int[] digits = new int[n1+n2];
        for(int i = n1-1; i >= 0 ; i--)
            for(int j = n2-1 ; j >= 0 ; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + digits[p2];
                digits[p2] = sum % 10;
                digits[p1] += sum / 10;
            }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < digits.length ; i++)
            if(!(sb.length()==0 && digits[i] == 0)) sb.append(digits[i]);
        return (sb.length() == 0) ? "0" : sb.toString(); // for case when result is 0 sb will be empty
	}
}
