/**
 * https://www.interviewbit.com/problems/intersection-of-sorted-arrays/ 
 */
public class Solution {
	// DO NOT MODIFY THE LISTS
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    if(a == null || a.isEmpty() || b == null || b.isEmpty()) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, m = a.size(), n = b.size();
        while(i < m && j < n){
            int aVal = a.get(i), bVal = b.get(j);
            if(aVal < bVal) i++;
            else if(bVal < aVal) j++;
            else{
                result.add(a.get(i));
                i++;
                j++;
            }
        }
        return result;
	}
}
