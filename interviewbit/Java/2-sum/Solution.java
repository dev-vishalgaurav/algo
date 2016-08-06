/**
 * https://www.interviewbit.com/problems/2-sum/
 */
public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> nums, int target) {
	    HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.size() ; i++){
            int diff = target - nums.get(i);
            if(map.containsKey(diff)) return new ArrayList<>(Arrays.asList(new Integer[]{map.get(diff)+1,i+1}));
            if(!map.containsKey(nums.get(i)))map.put(nums.get(i),i); // to maintain the mimimum order
        }
        return new ArrayList<>();
	}
}
