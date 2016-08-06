/**
 * https://www.interviewbit.com/problems/equal/
 */
public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
       HashMap<Long,Integer[]> map = new HashMap<>();
        Integer[] result = null;
        for(int i = 0 ; i < a.size(); i++){
            for(int j = i+1 ; j < a.size() ; j++){
                long sum = a.get(i) + a.get(j);
                if(map.containsKey(sum)){
                    Integer[] prev = map.get(sum);
                    if(prev[0] == i || prev[0] == j || prev[1] == i || prev[1] == j ) continue; // not a valid pair
                    // check empty or lexicographic order
                    Integer[] cur = new Integer[]{prev[0],prev[1],i,j};
                    if(result == null || isSmaller(result, cur))
                            result = cur;
                }else{
                    map.put(sum, new Integer[]{i,j});
                }
            }
        }
        return result == null ? new ArrayList<>(): new ArrayList<>(Arrays.asList(result));
    }
    
    private boolean isSmaller(Integer[] a, Integer[] b){
        for(int i = 0 ; i < 4 ; i++){
            if(a[i] < b[i]) return false;
            if(a[i] > b[i]) return true;
        }
        return false;
    }
}
