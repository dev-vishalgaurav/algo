/**
 * https://www.interviewbit.com/problems/power-of-2/
 */
public class Solution {
	public int power(String num) {
	    if(num == null || num.isEmpty()) return 0;
        if(num.length() == 1) return  "248".indexOf(num.charAt(0)) >= 0 ? 1 : 0;
        if("2486".indexOf(num.charAt(num.length() - 1)) < 0) return 0;
        // now divide by 2;
        int start = 0, carry = 0, n = num.length(); 
        while(num.charAt(start) == '0')start++;
        StringBuilder sb = new StringBuilder();
        for(int i = start ; i < n ; i++ ){
            int digit = num.charAt(i) - '0' + carry;
            if(digit > 0 && digit < 2 && ++i < n){
                digit = (digit * 10) + num.charAt(i) - '0';
                sb.append(0);
            }else if(digit > 0 && digit < 2) return 0;
            sb.append(digit/2);
            carry = digit % 2 * 10;
        }
        return power(sb.toString());
	}
}
