/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        utils("",n, n,result);
        return result;
    }
    
    private void utils(String prefix, int openers, int closers, List<String> result ){
        if( openers == 0 && closers == 0){
            result.add(prefix);
            return;
        }
        if(openers > 0){
            utils(prefix+"(", openers -1,closers,result);
        }
        if(closers > 0 && openers < closers){ // 2nd condition is necessary
            utils(prefix+")",openers,closers - 1, result);
        }
        
    }
}