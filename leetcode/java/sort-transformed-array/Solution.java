public class Solution {
    /**
	* https://leetcode.com/problems/sort-transformed-array/
	* Naive solution not O(n)
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
        return (a*x*x) + b*x + c;
    }
}