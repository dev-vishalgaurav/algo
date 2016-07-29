/**
 * https://www.interviewbit.com/problems/array-3-pointers/
 */
public class Solution {
	// DO NOT MODIFY THE LISTS
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
	    if(a == null || a.isEmpty() || b == null || b.isEmpty() || c == null || c.isEmpty()) return Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0, result = Integer.MAX_VALUE;
        while(i < a.size() && j < b.size() && k < c.size()){
            int min = Math.min(Math.min(a.get(i), b.get(j)),c.get(k));
            int max = Math.max(Math.max(a.get(i), b.get(j)),c.get(k));
            int diff = max - min;
            result = Math.min(diff, result);
            if(a.get(i).equals(min))i++;
            else if(b.get(j).equals(min))j++;
            else k++;
        }
        return result;
	}
}
