/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {
	/**
	 * Tracersing from back.
	 */
    public int maxProfit(int[] prices) {
        if(prices.length == 0 ) return 0;
        int total = 0, profit = 0 , i = prices.length - 2, j = prices.length - 1;
        while(i >= 0){
            if(prices[i] <= prices[i+1]){
                profit = Math.max(profit,prices[j] - prices[i--]);
            }else{
                total += profit;
                profit = 0;
                j = i-- ;
            }
        }
        return total + profit;
    }
	/**
	 * shorter and traversing from front 
	 */
	public int maxProfit(int[] prices) {
        if(prices.length < 2 ) return 0;
        int maxProfit = 0, bought = prices[0];
        for(int p: prices){
            if(p > bought) 
                maxProfit += p - bought;
            bought = p;
        }
        return maxProfit;
    }
	/**
	 * Even shorter.
	 */
	public int maxProfit(int[] prices) {
        int total = 0;
        for(int i = 0 ; i < prices.length - 1; i++)
            if(prices[i+1] > prices[i]) total += prices[i+1] - prices[i];
        return total;
    }
}