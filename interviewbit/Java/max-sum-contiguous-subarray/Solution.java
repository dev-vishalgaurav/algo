/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/ 
 */
public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	   int max = Integer.MIN_VALUE ,sum = Integer.MIN_VALUE;
        for(int num : a){
            if(sum < 0) sum = Math.max(sum, num);
            else if(sum + num > 0) sum += num;
            else sum = num;
            max = Math.max(max, sum);
        }
        return max;
	}
}
