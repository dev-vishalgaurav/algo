/**
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 */
public class Solution {
	/**
	 * Using O(k) max space
	 */
	public ArrayList<Integer> getRow(int k) {
	    if(k < 0) return new ArrayList<>();
	    k++;
        ArrayList<Integer> result = new ArrayList<>();
        for( int i = 1 ; i <= k ; i++ ){
            for(int j = i-2; j > 0 ; j--){
                 result.set(j, result.get(j)+ result.get(j-1));
            }
            result.add(1);
        }
        return result;
	}
}
