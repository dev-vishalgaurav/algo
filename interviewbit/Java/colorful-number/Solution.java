/**
 * https://www.interviewbit.com/problems/colorful-number/
 */
public class Solution {
	public int colorful(int a) {
	    String num = String.valueOf(a);
        int n = num.length();
        long[] mul = new long[n];
        for(int i = 0 ; i < n ; i++ ){
            int digit = num.charAt(i) - '0';
            if(digit == 0 && n > 1) return 0;
            if(i == 0 || mul[i-1] == 0) mul[i] = digit ;
            else mul[i] = mul[i-1] * digit; 
        }
        HashSet<Long> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                long val = (i == 0) ? mul[j] : mul[j] / mul[i-1];
                if(set.contains(val)) return 0;
                set.add(val);
            }
        }
        return 1;
	}
}
