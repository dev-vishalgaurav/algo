/**
 * https://www.interviewbit.com/problems/jump-game-array/
 */
public class Solution {
	public int canJump(ArrayList<Integer> nums) {
	    if(nums == null || nums.isEmpty()) return 1;
        int max = 0;
        for(int i = 0 ; i < nums.size() ; i++){
            if(i > max) return 0;
            max = Math.max(max,nums.get(i) + i);
        }
        return 1;
	}
}
