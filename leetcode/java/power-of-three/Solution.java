/**
 * https://leetcode.com/articles/power-of-three/
 * https://leetcode.com/problems/power-of-three/
 */
 public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
	public boolean isPowerOfThree(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0; 
    }
	public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        int maxPowerOf3 = (int)(Math.log10(Integer.MAX_VALUE) / Math.log10(3));
        int maxNumPower3WithInIntRange = (int)Math.pow(3, maxPowerOf3);
        return maxNumPower3WithInIntRange % n == 0;    
    }
}