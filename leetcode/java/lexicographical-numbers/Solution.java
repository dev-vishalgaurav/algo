/**
 * https://leetcode.com/contest/1/problems/lexicographical-numbers/
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        getLexicalOrder(1, n, result);
        return result;
    }
    private void getLexicalOrder(int start,int n, List<Integer> result){
        if(start > n) return;
        for(int i = 0  ; i < 10 && start + i <= n ; i++){
            int num = start + i;
            result.add(num);  
            getLexicalOrder(num*10,n,result);
            if((num + 1) % 10 == 0) return;
        }
    }
}