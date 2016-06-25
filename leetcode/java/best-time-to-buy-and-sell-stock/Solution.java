/**
 * Solution to Leetcode problem best time to buy and sell stock using Divide and Conquer technique
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {
	/**
	 * using divide and conquer
	 */
    public int maxProfit(int[] prices) {
        return prices.length > 0 ? helper(prices,0,prices.length -1)[0] : 0;
    }
    private int[] helper(int[] prices, int i, int j){
        int[] result = {0,prices[i],prices[j]};
        if(i == j) return result;
        int m = i + (j - i) / 2 ;
        int[] left = helper(prices,i,m);
        int[] right = helper(prices,m+1,j);
        result[0] = Math.max(left[0],Math.max(right[0],right[1] - left[2]));
        result[1] = Math.max(left[1],right[1]);
        result[2] = Math.min(left[2],right[2]);
        return result;
    }
}