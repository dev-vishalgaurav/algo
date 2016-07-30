/**
 * https://www.interviewbit.com/problems/different-bits-sum-pairwise/
 */
public class Solution {
    public int cntBits(ArrayList<Integer> a) {
        long result = 0 , n = a.size(), count = 0, mod = (int) Math.pow(10,9) + 7;
        for(int i  = 0 ; i < 32 ; i++){
            count = 0;
            int curShift = 1 << i;
            for(int num : a ){
                if((curShift & num) > 0 ) count++;
            }
            result +=  count * (n - count) * 2;
            result = result % mod;
        }
        return (int) result;
    }
}
