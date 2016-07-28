/**
 * https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 */
public class Solution {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    if(a == null || b == null) return;
        int m = a.size(), n = b.size();
        for(int i = 0 ; i < n ; a.add(0), i++);
        int i = m - 1, j = n-1, k = m + n - 1;
        while(j >= 0){
            a.set(k--, i >= 0 && b.get(j).compareTo(a.get(i)) <= 0 ? a.get(i--) : b.get(j--));
        }
	}
}
