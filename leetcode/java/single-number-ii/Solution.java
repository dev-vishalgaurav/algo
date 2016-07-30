/**
 * https://leetcode.com/problems/single-number-ii/
 */
public class Solution {
	/**
	*  https://discuss.leetcode.com/topic/11877/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers/2
	 */
    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for(int i : nums){
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}