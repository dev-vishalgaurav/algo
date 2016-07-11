/**
 * https://leetcode.com/problems/combinations/
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        utils(1,n,k,new ArrayList<Integer>(), result);
        return result;
    }
    
    private void utils(int start,int n, int k , List<Integer> cur, List<List<Integer>> result ){
        if(k == 0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start ; i <= n ; i++){
            cur.add(i);
            utils(i+1,n,k-1,cur,result);
            cur.remove(cur.size() -1);
        }
    }
    
}