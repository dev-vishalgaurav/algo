/**
 * https://www.interviewbit.com/problems/sorted-permutation-rank/
 */
public class Solution {
	public int findRank(String a) {
	    if(a == null || a.isEmpty()) return 0;
        long[] count = new long[256], factA = getModFactorial(a.length(),1000003 );
        int len = a.length(), rank = 1;
        for(int i = 0 ; i < a.length(); count[a.charAt(i)]++ , i++); // get count of each chars
        for(int i = 1 ; i < 256 ; count[i] += count[i-1], i++); // make a prefix array
        
        for(int i = 0 ; i < len; i++){
            long fact = factA[len - i -1];
            int index = a.charAt(i);
            if(index > 0 && count[index - 1] > 0){
                rank += (fact * count[index - 1]) % 1000003;
            }
            for(int j = index; j < 256; count[j]--, j++ );
        }
        return (int) (rank % 1000003);
	}
	    /**
     * returns factorial array with mod
     */
    private long[] getModFactorial(int n, int mod){
        long[] fact = new long[n+1];
        fact[0] = fact[1] = 1;
        for(int i = 2 ; i <= n; i++ ) 
              fact[i] = (fact[i-1]  * i) % mod ;
        return fact;
    }
	
}
