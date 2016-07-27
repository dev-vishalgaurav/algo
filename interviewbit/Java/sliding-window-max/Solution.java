/**
 * https://www.interviewbit.com/problems/sliding-window-max/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> slidingMaximum(final List<Integer> nums, int k) {
        if(k == 0 || nums == null || nums.size() == 0 || k > nums.size()) return new ArrayList<>();
        if(k == 1) return new ArrayList<>(nums);
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        // get maximum of first window at dq.getFirst().
        for(int i = 0 ; i < k ; i++){
            while(!dq.isEmpty() && nums.get(dq.getLast()) <= nums.get(i)) dq.removeLast();
            dq.addLast(i);
        }
        for(int i = k ; i < nums.size() ; i++){
            result.add(nums.get(dq.getFirst()));
            // remove all the smaller from last as we did for the first sliding window
            while(!dq.isEmpty() && nums.get(i) >= nums.get(dq.getLast())) dq.removeLast();
            // remove the elements which are not part of sliding window
            while(!dq.isEmpty() && dq.getFirst() <= i - k) dq.removeFirst();
            dq.addLast(i);
        }
        result.add(nums.get(dq.getFirst()));
        return result;
	}
}
