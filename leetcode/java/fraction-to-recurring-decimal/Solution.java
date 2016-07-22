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
}