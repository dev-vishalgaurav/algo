/**
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
	public int removeDuplicates(ArrayList<Integer> nums) {
	    if(nums == null) return 0;
	    if(nums.size() <= 1) return nums.size();
        int i = 0 , j = 1, n = nums.size();
        while(j < n){
            if(nums.get(j).equals(nums.get(i))) j++;
            else nums.set(++i,nums.get(j++));
        }
        return i+1;
	}
}
