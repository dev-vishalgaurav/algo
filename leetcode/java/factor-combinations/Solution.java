/**
 *https://leetcode.com/problems/factor-combinations/
 */
public class Solution {
    
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        futils(2,n,new ArrayList<Integer>(),result);
        return result;
    }
    
    private void futils(int start, int num, List<Integer> factors, List<List<Integer>> result){
        if(num <= 1 && factors.size() > 1){
            result.add(new ArrayList<Integer>(factors));
            return;
        }
        for(int i = start ; i <= num ; i++){
            if(num % i == 0){
                factors.add(i);
                futils(i, num/i,factors,result);
                factors.remove(factors.size()-1);
            }
        }
    }
    /**
     * this method is much faster because of the max parameter
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        futils(2,n,(int)Math.sqrt(n),new ArrayList<Integer>(),result);
        return result;
    }
    
    private void futils(int start, int num,int max, List<Integer> factors, List<List<Integer>> result){
        if(num <= 1 && factors.size() > 1){
            result.add(new ArrayList<Integer>(factors));
            return;
        }
        for(int i = start ; i <= num ; i++){
            if(i > max)
                i = num;
            if(num % i == 0){
                factors.add(i);
                futils(i, num/i,max,factors,result);
                factors.remove(factors.size()-1);
            }
        }
    }
}