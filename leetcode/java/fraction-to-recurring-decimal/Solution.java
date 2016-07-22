/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        if(d == 0) return null;
        if(n == 0) return "0";
        if(n % d == 0) return ""+ n/d; 
        boolean isNeg = n*d < 0;
        n = Math.abs(n); d = Math.abs(d);
        String prefix = (isNeg ? "-":"")  + n/d + ".";
        HashMap<Long,Integer> set = new HashMap<>();
        String result = prefix + getFraction(n % d *10, d,"",set);
        return result;
    }
    
    private String getFraction(long n, long d, String cur,HashMap<Long,Integer> set){
        if(set.containsKey(n)) return cur.substring(0,set.get(n)) + "(" + cur.substring(set.get(n),cur.length())  + ")";
        set.put(n,cur.length());
        cur += n/d;
        if(n % d == 0) return cur ;
        return getFraction((n%d) * 10,d,cur,set);
    }
	/**
	* Without recursion . https://leetcode.com/articles/fraction-recurring-decimal/
	*/
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder fraction = new StringBuilder();
		// If either one is negative (not both)
		if (numerator < 0 ^ denominator < 0) {
			fraction.append("-");
		}
		// Convert to Long or else abs(-2147483648) overflows
		long dividend = Math.abs(Long.valueOf(numerator));
		long divisor = Math.abs(Long.valueOf(denominator));
		fraction.append(String.valueOf(dividend / divisor));
		long remainder = dividend % divisor;
		if (remainder == 0) {
			return fraction.toString();
		}
		fraction.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (remainder != 0) {
			if (map.containsKey(remainder)) {
				fraction.insert(map.get(remainder), "(");
				fraction.append(")");
				break;
			}
			map.put(remainder, fraction.length());
			remainder *= 10;
			fraction.append(String.valueOf(remainder / divisor));
			remainder %= divisor;
		}
    return fraction.toString();
}
}