/**
 * https://www.interviewbit.com/problems/bulbs/
 */
public class Solution {
    public int bulbs(ArrayList<Integer> a) {
        if(a == null || a.size() == 0) return 0;
        int count = 0 , state = 0; // we need to switch on from left most side of array
        for(int i = 0; i<a.size(); i++){
            if(a.get(i) == state){
                count++;
                state = 1-state;
            }
        }
       return count;
    }
}
