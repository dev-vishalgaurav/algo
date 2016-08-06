/**
 * https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
 */
public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        HashMap<Long,Integer> map = new HashMap<>();
        int ri = 0, rj = 0;
        long sum = 0;
        for(int i = 0 ; i < a.size() ; i++){
            sum += a.get(i);
            if(a.get(i) == 0 && rj - ri == 0){
                ri = i;
                rj = i+1;
            }
            if(sum == 0){
                ri = 0;
                rj = i + 1;
            }
            if(map.containsKey(sum)){
                if(i - (map.get(sum)) > rj - ri){
                    rj = i + 1;
                    ri = map.get(sum) + 1;
                }
            }else{
                map.put(sum, i);
            }
            
        }
        return new ArrayList<Integer>(a.subList(ri,rj));
    }
}
