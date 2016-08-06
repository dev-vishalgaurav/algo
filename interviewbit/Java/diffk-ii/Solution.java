/**
 * https://www.interviewbit.com/problems/diffk-ii/
 */
public class Solution {
	public int diffPossible(final List<Integer> a, int b) {
	    // find an index with a.get(i) - k = a.get(j) 
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0 ; i < a.size(); i++){
            int val = a.get(i) - b;
            int nval = b + a.get(i);
            if(map.contains(val)) return 1;
            if(map.contains(nval)) return 1;
            map.add(a.get(i));
        }
        return 0;
	}
}
