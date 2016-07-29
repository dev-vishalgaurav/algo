/**
 * https://www.interviewbit.com/problems/diffk/ 
 */
public class Solution {
	public int diffPossible(ArrayList<Integer> a, int b) {
	   if(a == null || a.isEmpty() || a.size() == 1) return 0;
        int i = 0 , j = 1 , n = a.size();
        while(i < n && j < n){
            int diff = a.get(j) - a.get(i);
            if(i != j && diff == b) return 1;
            else if( diff > b) i++;
            else j++ ;
        }
        return 0;
	}
}
