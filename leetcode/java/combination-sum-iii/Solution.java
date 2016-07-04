/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        utils(k,n,1,new ArrayList<>(),result);
        return result;
    }
    
    private void utils(int k, int n, int start, List<Integer> path,List<List<Integer>> result){
        if(n == 0 && k == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start ; i <= 9 ; i++){
            if(n - i >= 0){
                path.add(i);
                utils(k-1,n-i,i+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}