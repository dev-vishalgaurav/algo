/**
 * https://leetcode.com/problems/remove-element/
 */
public class Solution {
    public int removeElement(int[] a, int b) {
        if(a == null || a.length == 0) return 0;
        int i = 0, j = 0,n = a.length;
        while(j < n){
            if( i == j && (a[i] != b && a[j]!= b)) i = ++j;
            else if(a[j] == b) j++;
            else if(a[i]!= b)i++;
            else swap(a,i++, j++);
        }
        return i;
    }
	/**
	 * Much simpler when putting the second pointer at last, But this does not maintain the relative order.
	 */
	public int removeElement(int[] nums, int val) {
        int start = 0 , end = nums.length - 1, total = nums.length;
        while(start <= end){
            if(nums[end] == val) end--;
            else if(nums[start] == val) swap(nums,start++,end--);
            else start++;
        }
        return start;
    }
    private static void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}