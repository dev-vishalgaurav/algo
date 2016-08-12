/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
import java.util.Random;
public class Solution {
    private int[] nums = null;
    private Random random = null;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random(System.currentTimeMillis());
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums,nums.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = Arrays.copyOf(nums,nums.length);
        for(int i = 1 ; i < nums.length ; i++){
            int swapIndex = random.nextInt(i+1);
            swap(ans,i,swapIndex);
        }
        return ans;
    }
    private void swap(int[] ans, int from , int to){
        int temp = ans[from];
        ans[from] = ans[to];
        ans[to] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */