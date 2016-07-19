/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        for(int i = 0; i < numRows ; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1 ; j <= i ; j++){
                List<Integer> prev = result.get(i-1); 
                int left = (prev.get(j-1));
                int top = prev.size() > j ? prev.get(j) : 0;
                row.add(left + top);
            }
            result.add(row);
        }
        return result;
    }
}