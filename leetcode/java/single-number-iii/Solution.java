/**
 * https://leetcode.com/problems/single-number-iii/
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0, n = nums.length;
        for(int i = 0 ; i < n ;i++) diff ^= nums[i];
        diff &= -diff; // keeps only the last set bit.
        int[] result = {0,0};
        for(int num : nums){
            if((num & diff) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;
    }
	/**
	 * Using extra memory
	 */
	public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        ArrayList<Integer> r = new ArrayList<>(set); 
        return new int[] {r.get(0),r.get(1)};
    }
}