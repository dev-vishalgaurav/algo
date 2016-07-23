/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray
 */
public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    ArrayList<Integer> result = new ArrayList<>();
        long maxSum = 0;
        int i = 0;
        ArrayList<Integer> next = new ArrayList<>();
        while(i < a.size() ){
            next.clear();
            if(a.get(i) < 0){
                i++;
                continue;
            }
            long sum = getPveSubarray(a, next, i);
            if(sum > maxSum || (sum == maxSum && next.size() > result.size()) ){
                maxSum = sum;
                result.clear();
                result.addAll(next);
            }
            i += next.size();
        }
        return result;
	}
	
	private long getPveSubarray(List<Integer> a, ArrayList<Integer> list, int start){
        long sum = 0;
        for(int i = start ; i < a.size() && a.get(i) >= 0 ; i++){
            int num = a.get(i);
            list.add(num);
            sum += num;
        }
        return sum;
    }
	
	
}
