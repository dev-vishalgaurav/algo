/**
 * https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(n < 0)return result;
        for(int i = 0 ; i < n ; i++) result.add(new ArrayList<>(Arrays.asList(new Integer[n])));
        int total = n * n, count = 0, layer = 0;
        while(count < total){
            for(int j = layer; j < n - layer && count < total; j++){
                result.get(layer).set(j,++count);
            }
            for(int i = layer + 1 ; i < n - layer - 1 && count < total; i++){
                result.get(i).set(n-layer -1, ++count);
            }
            for(int j = n - layer - 1 ; j >= layer && count < total; j--){
                result.get(n-layer - 1).set(j, ++count);
            }
            for(int i = n - layer - 2 ; i >= layer + 1 && count < total; i--){
                result.get(i).set(layer, ++count);
            }
            layer++;
        }
        
        return result;
	}
}
