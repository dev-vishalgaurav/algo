/**
 * https://www.interviewbit.com/problems/3-sum/
 */
public class Solution {
	public int threeSumClosest(ArrayList<Integer> a, int b) {
	   if(a == null || a.size() < 3) return 0;
        Collections.sort(a);
        int closest = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        for(int i = 0 ; i < a.size() - 2; i++){
            int j = i + 1, k = a.size() - 1;
            while( j < k){
                int sum = a.get(i) + a.get(j) + a.get(k);
                int diff = Math.abs(sum-b);
                if(diff == 0) return sum;
                if(diff < closest){
                    closest = diff;
                    result = sum;
                }
                if (sum > b) k--;
                else j++;
            }
        }
        return result;
	}
}
