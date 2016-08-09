/**
 *https://www.interviewbit.com/problems/kth-permutation-sequence/
 */
public class Solution {
	public String getPermutation(int n, int k) {
	   if(k <= 0 || n <= 0 ) return "";
       ArrayList<Integer> num = new ArrayList<Integer>();
       for(int i = 0 ; i < n ; i++) num.add(i+1);
       return getPermutation(k-1, num);
	}
    
    private String getPermutation(int k,ArrayList<Integer> nums ){
        int n = nums.size();
        if (n == 0) return "";
        if (k > factorial(n)) return ""; // invalid. Should never reach here.
        
        int f = factorial(n - 1);
        int pos = k / f;
        k %= f;
        String ch = "" + nums.get(pos);
        // now remove the character ch from candidateSet. 
        nums.remove(pos);
        return ch + getPermutation(k, nums);
    }
    	
	private int factorial(int n){
	    if(n > 12) return Integer.MAX_VALUE;
	    int fact = 1;
	    for(int i = 2 ; i <= n ; i++) fact *= i;
	    return fact;
	}
}
