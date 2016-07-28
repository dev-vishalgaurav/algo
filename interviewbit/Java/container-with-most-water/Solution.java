/**
 * https://www.interviewbit.com/problems/container-with-most-water/
 */
public class Solution {
	public int maxArea(ArrayList<Integer> a) {
	    if(a == null || a.isEmpty() || a.size() == 1) return 0;
        int i = 0 , j = a.size() - 1, n = a.size(), area = 0 ; 
        while(i < j){
            area = Math.max(area, (j-i) * (a.get(j) > a.get(i) ? a.get(i++) : a.get(j--)));
        }
        return area;
	}
}
