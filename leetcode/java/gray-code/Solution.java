/**
 * https://leetcode.com/problems/gray-code/
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
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
}