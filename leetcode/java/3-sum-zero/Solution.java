/**
 * https://www.interviewbit.com/problems/3-sum-zero/ 
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
	    return getTriplets(a,0);
	}
	private ArrayList<ArrayList<Integer>> getTriplets(ArrayList<Integer> a, int b){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a == null || a.size() < 3) return result;
        Collections.sort(a);
        for(int i = 0 ; i < a.size() ; i++){
            if( i > 0 && a.get(i).equals(a.get(i -1))) continue;
            int j = i + 1, k = a.size() - 1;
            while(j < k){
                int sum = a.get(i) + a.get(j) + a.get(k);
                if(sum == b){
                    result.add(new ArrayList<>(Arrays.asList(new Integer[]{a.get(i),a.get(j),a.get(k)})));
                    j++; k--;
                    while(j < a.size() && a.get(j).equals(a.get(j-1))) j++;
                    while(k > 0 && a.get(k).equals(a.get(k+1))) k--;
                }else if( sum > b ) k-- ;
                 else j++; 
            }
        }
        return result;
    }
}
