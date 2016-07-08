/**
 * https://leetcode.com/problems/contains-duplicate-iii/ 
 */
public class Solution {
	/**
     * https://leetcode.com/articles/contains-duplicate-iii/ 
	 *
	 */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set =  new TreeSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            Integer ceil = set.ceiling(nums[i]);
            if(ceil!=null && ceil <= nums[i] + t) return true;
            Integer floor = set.floor(nums[i]);
            if(floor!=null && nums[i] <= floor + t) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
	    
    /**
     * logic details in editorial
     * https://leetcode.com/articles/contains-duplicate-iii/
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        HashMap<Long,Long> map = new HashMap<>();
        long range = (long) (t + 1); // to avoid t = 0;
        for(int i = 0 ; i < nums.length ; i++){
            long label = getBucketLabel(nums[i], range);
            if(map.containsKey(label)) return true;
            if(map.containsKey(label - 1) && Math.abs(map.get(label - 1) - nums[i]) < range ) 
                return true;
            if(map.containsKey(label + 1) && Math.abs(map.get(label + 1) - nums[i]) < range ) 
                return true;
            map.put(label,(long)nums[i]);
            if(i >= k) // keep shifting the window
                map.remove(getBucketLabel(nums[i-k], range));
                
        }
        return false;
    }
    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getBucketLabel(long val, long range){
        return val < 0 ? (val + 1 / range - 1): val / range;
    }
}