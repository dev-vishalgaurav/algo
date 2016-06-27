/**
 * https://leetcode.com/problems/sort-transformed-array/
 */
public class Solution {

	/**
	 * Efficient solution inspired from this link https://leetcode.com/discuss/108831/java-o-n-incredibly-short-yet-easy-to-understand-ac-solution
	 * 
	 */
	 public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length-1, startIndex = (a >= 0) ? nums.length - 1 : 0;
        while(i <= j){
            int sqrsi = getVal(nums[i],a,b,c);
            int sqrsj = getVal(nums[j],a,b,c);
            if(a >= 0){
                if(sqrsi >= sqrsj){
                    result[startIndex--] = sqrsi;
                    i++;
                }else{
                    result[startIndex--] = sqrsj;
                    j--;
                }
            }else{
                if(sqrsi >= sqrsj){
                    result[startIndex++] = sqrsj;
                    j--;
                }else{
                    result[startIndex++] = sqrsi;
                    i++;
                }
            }
        }
        return result;
    }
	/**
	 * Shorter version of the above implementation
	 */
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] result = new int[nums.length];
		int[] sqrs = new int[nums.length];
		int i = 0, j = nums.length-1, startIndex = (a >= 0) ? nums.length - 1 : 0;
		while(i <= j){
			sqrs[i] = (sqrs[i] == 0 ) ? getVal(nums[i],a,b,c) : sqrs[i] ;
			sqrs[j] = (sqrs[j] == 0 ) ? getVal(nums[j],a,b,c) : sqrs[j];
			if(a>=0)
				result[startIndex--] = sqrs[i] >= sqrs[j] ? sqrs[i++] : sqrs[j--]; // sorting from last
			else
				result[startIndex++] = sqrs[i] >= sqrs[j] ? sqrs[j--] : sqrs[i++]; // sorting from begining
		}
		return result;
	}
	/**
	 * Naive Solution 
	 */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = getVal(nums[i],a,b,c);
            int j = i;
            while(j > 0 && result[j -1] > result[j])
                swap(result,j--,j);
        }
        return result;
    }
    private void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
    private int getVal(int x, int a , int b, int c){
        return a*x*x + b*x + c;
    }
}