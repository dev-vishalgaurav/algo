/**
 *https://www.interviewbit.com/problems/distribute-candy/
 */
public class Solution {
	public int candy(ArrayList<Integer> ratings) {
	    if(ratings == null || ratings.size() == 0) return 0;
        int total = 0, n = ratings.size();
        int[] left = new int[n], right = new int[n];
        for(int i = 0, j = n-1 ; i < n ; i++,j--){
            if(i > 0 && ratings.get(i-1) < ratings.get(i)) left[i] = left[i-1] + 1;
            else left[i] = 1;
            if(j+1 < n && ratings.get(j) > ratings.get(j+1)) right[j] = right[j+1] + 1;
            else right[j] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            total += Math.max(left[i],right[i]);
        }
        return total;
	}
}
