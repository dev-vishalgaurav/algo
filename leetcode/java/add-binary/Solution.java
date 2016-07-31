/**
 * https://leetcode.com/problems/add-binary/
 */
public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int first = i >= 0 ? a.charAt(i--) - '0' : 0;
            int second = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = first + second + carry;
            carry = sum >= 2 ? 1 : 0;
            int cur = sum % 2 == 0 ? 0 : 1 ;
            result = cur + result;
        }
        if(carry == 1) result = carry + result;
        for(i = 0 ; i < result.length() - 1 && result.charAt(i) == '0'; i++);
        return result.substring(i,result.length()); 
    }
}