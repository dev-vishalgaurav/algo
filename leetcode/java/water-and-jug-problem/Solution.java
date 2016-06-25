/**
 * https://leetcode.com/problems/water-and-jug-problem/
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
       return z == 0 || z <= x + y && z % GCD(x,y) == 0  ;
    }
    private int GCD(int a, int b) { 
        return b==0 ? a : GCD(b, a%b);  
    }
	private int GCD_L(int a, int b){
		while (b > 0)
		{
			int temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}
}
