/**
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution {
	public int removeDuplicates(ArrayList<Integer> nums) {
	   if(nums.size() <= 2 ) return nums.size();
        int i = 1, j = 2, n = nums.size();
        while(j < n){
            if(nums.get(j).equals(nums.get(i)) && nums.get(i).equals(nums.get(i-1))) j++;
            else nums.set(++i,nums.get(j++)); 
        }
        return i+1;
	}
}
