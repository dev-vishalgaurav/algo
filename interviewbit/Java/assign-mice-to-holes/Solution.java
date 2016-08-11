/**
 *https://www.interviewbit.com/problems/assign-mice-to-holes/
 */
public class Solution {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a == null || b == null || a.size() != b.size()) return Integer.MAX_VALUE;
        Collections.sort(a);
        Collections.sort(b);
        int n = a.size(), result  = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            result = Math.max(result,Math.abs(a.get(i)-b.get(i)));
        }
        return result;
    }
}
