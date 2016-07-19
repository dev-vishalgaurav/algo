/**
 * https://leetcode.com/problems/missing-ranges/
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int start = lower - 1;
        for(int i = 0 ; i <= nums.length ; i++){
            int num = i < nums.length ? nums[i] : upper+1; ;
            if(num - start > 1){
             int diff = num - start - 1, first = start + 1;
             String s = ""+first;
             if(diff > 1) 
                s += "->" + (first + diff - 1);
             result.add(s);
            }
            start = num;
        }
        return result;
    }
}