/**
 *https://www.interviewbit.com/problems/4-sum/
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<ArrayList<Integer>> set = new TreeSet<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for(int i = 0 ; i < 4 ; i++){
                    if(o1.get(i) < o2.get(i)) return -1;
                    if(o1.get(i) > o2.get(i)) return 1;
                }
                return 0;
            }
        });
        Arrays.sort(nums);
        HashMap<Long,ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ;j++){
                long pairSum = nums[i] + nums[j];
                if(!map.containsKey(pairSum)) map.put(pairSum,new ArrayList<int[]>());
                map.get(pairSum).add(new int[]{i,j});
            }
        }
        for(Map.Entry<Long,ArrayList<int[]>> pair : map.entrySet()){
            long sum = pair.getKey(), diff = target - sum;
            if(!map.containsKey(diff)) continue;
            ArrayList<int[]> first = pair.getValue();
            if(diff == sum && first.size() == 1) continue;
            ArrayList<int[]> second = map.get(diff);
            for(int[] pair1 : first)
                for(int[] pair2 : second){
                    if(pair1 == pair2) continue;
                    int i1 = pair1[0], j1 = pair1[1], i2 = pair2[0], j2 = pair2[1];
                    if(i1 == i2 || i1 == j2 || j1 == i2 || j1 == j2) continue; 
                    ArrayList<Integer> quad = new ArrayList<>(Arrays.asList(new Integer[]{nums[i1],nums[j1],nums[i2],nums[j2]}));
                    Collections.sort(quad);
                    set.add(quad);
                }
        }
        result.addAll(set);
        return result;
    }
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(nums);
        int n = nums.size();
        for(int i = 0 ; i < n - 3; i++){
            if(i > 0 && nums.get(i-1) == nums.get(i) ) continue;
            for(int j = i + 1 ; j < n - 2 ; j++){
                if(j > i+1 && nums.get(j-1) == nums.get(j) ) continue;
                int k = j+1, l = n - 1;
                while( k < l){
                    long sum = nums.get(i) + nums.get(j) + nums.get(k) + nums.get(l);
                    if(sum == target){
                        result.add(new ArrayList<>(Arrays.asList(new Integer[]{nums.get(i),nums.get(j),nums.get(k),nums.get(l)})));
                        k++; l--;
                        while(k < l && nums.get(k) == nums.get(k-1)) k++; // check for duplicate j
                        while(k < l && nums.get(l) == nums.get(l+1)) l--; // check for duplicate k
                    }else if( sum > target) l--;
                     else k++;
                }
            }
        }
        return result;
	}
}