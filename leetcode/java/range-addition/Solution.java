/**
 * https://leetcode.com/problems/range-addition/
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int[] update : updates){
            result[update[1]] += update[2];
            if(update[0] > 0 ) result[update[0] - 1] -= update[2];
        }
        for(int i = length - 2 ; i >= 0 ; i--){
            result[i] = result[i] + result[i+1];
        }  
        return result;
    }
}