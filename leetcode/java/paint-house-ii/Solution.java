/**
 * https://leetcode.com/problems/paint-house-ii/
 */
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1; // min1 is smallest
        for(int i = 0 ; i < n ; i++){
            int tmin1 = -1, tmin2 = -1;
            for(int j = 0 ; j < k ; j++){
                if(i > 0){ // no need to update prices before 1.
                    costs[i][j] += (min1 != j) ? costs[i-1][min1] : costs[i-1][min2];
                }
                if(tmin1 < 0 || costs[i][tmin1] > costs[i][j]){
                    tmin2 = tmin1; tmin1 = j;
                }else if(tmin2 < 0 || costs[i][tmin2] > costs[i][j])
                    tmin2 = j;
            }
            min1 = tmin1;
            min2 = tmin2;
        }
        return  costs[n-1][min1];
    }
    
}