/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0 || k > nums.length) return new int[]{};
        if(k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0, j = 0 ; i < nums.length; i++){
            if(i < k ) pq.add(nums[i]);
            else{
                result[j++] = pq.peek();
                pq.remove(nums[i - k]);
                pq.add(nums[i]);
            }
        }
        result[result.length -1] = pq.peek();
        return result;
    }
	
	/**
	 * using deque 
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0 || k > nums.length) return new int[]{};
        if(k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        // get maximum of first window at dq.getFirst().
        for(int i = 0 ; i < k ; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        for(int i = k ; i < nums.length ; i++){
            result[i-k] = nums[dq.getFirst()];
            // remove all the smaller from last as we did for the first sliding window
            while(!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) dq.removeLast();
            // remove the elements which are not part of sliding window
            while(!dq.isEmpty() && dq.getFirst() <= i - k) dq.removeFirst();
            dq.addLast(i);
        }
        result[result.length - 1] = nums[dq.getFirst()];
        return result;
    }
}