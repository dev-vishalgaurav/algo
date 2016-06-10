/**
* https://leetcode.com/submissions/detail/63923904/
*/
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[]dpTable = new int[amount + 1];
        Arrays.fill(dpTable, 1, dpTable.length,Integer.MAX_VALUE);
        for(int coinValue : coins){
                for(int denom = coinValue ; denom <= amount ; denom++ ){
                    if(dpTable[denom - coinValue] != Integer.MAX_VALUE){
                        dpTable[denom] = Math.min(dpTable[denom], dpTable[denom - coinValue] + 1);
					}
				}
		}
        return dpTable[amount] == Integer.MAX_VALUE ? -1 : dpTable[amount] ;
    }
}