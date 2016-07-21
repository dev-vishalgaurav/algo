/**
 * https://www.interviewbit.com/problems/first-missing-integer/
 */
public class Solution {
	public int firstMissingPositive(ArrayList<Integer> a) {
	    int i = 0 , n = a.size();
        while(i < n){
            if(a.get(i) < n && a.get(i) >= 0 && a.get(i) != a.get(a.get(i))){
                swap(a,i,a.get(i));
            }else{
                i++;
            }
        }
        int k = 1;
        while( k < n && k == a.get(k)) k++;
        
        if(n == 0 || n < k) return k;
        else return a.get(0) == k ? k + 1: k;
	}
	private void swap(final List<Integer> a, int from, int to){
        int temp = a.get(from);
        a.set(from, a.get(to));
        a.set(to, temp);
    }
}
