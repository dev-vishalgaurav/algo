/**
 * https://www.interviewbit.com/problems/gray-code/
 */
public class Solution {
	public ArrayList<Integer> grayCode(int n) {
	    ArrayList<Integer> result = new ArrayList<>();
        utils(0,0,n,result);
        return result; 
	}
    private void utils(int start,int sum,int left,List<Integer> result){
        if(left == 0){
            result.add(sum);
            return;
        }
        int nextSum = sum + (int) Math.pow(2, left - 1);
        if(start == 0){
            utils(0,sum,left - 1,result);
            utils(1,nextSum,left - 1,result);
        }else{
            utils(0,nextSum,left - 1,result);
            utils(1,sum,left - 1,result);
        }
    }
	/**
	 * Iterative version
	 */
	public ArrayList<Integer> grayCode(int n) {
	   ArrayList<Integer> result = new ArrayList<>(Arrays.asList(new Integer[]{0}));        
        for (int i = 0; i < n; i++) {
            int curSize = result.size();
            // push back all element in result in reverse order
            for (int j = curSize - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            } 
        }
        return result;
	}
}
