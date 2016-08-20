/**
 * https://www.interviewbit.com/problems/coin-sum-infinite/
 */
public class Solution {
    public int coinchange2(ArrayList<Integer> a, int b) {
        if(a == null || b == 0) return 0;
        long[] dp = new long[b+1];
        dp[0] = 1;
        for(int coin : a){
            for(int i = 1 ; i < dp.length ; i++){
                if(coin > i) continue;
                dp[i] = dp[i] + dp[i - coin]; 
                dp[i] = dp[i] % 1000007;
            }
        }
        return (int)(dp[b] % 1000007);
    }
}
