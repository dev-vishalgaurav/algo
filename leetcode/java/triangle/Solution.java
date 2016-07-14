/**
 * https://leetcode.com/problems/triangle/
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size()  ;
        if( size == 0) return 0;
        List<Integer> dp = triangle.get(size - 1);
        for(int i = size - 2 ; i >=0 ; i--){
            List<Integer> row = triangle.get(i);
            for(int j = 0 ; j < row.size(); j++){
                dp.set(j,Math.min(dp.get(j), dp.get(j+1)) + row.get(j));
            }
        }
        return dp.get(0);
    }
}