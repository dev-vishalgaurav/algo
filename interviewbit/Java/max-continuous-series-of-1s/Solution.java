/**
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/
 */
public class Solution {
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
       if(a == null || a.isEmpty()) return new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, ri = 0, rj = 0, m = b, n = a.size();
        while(j < n && (n - i) > (rj - ri)){
            if(a.get(j) == 1) j++;
            else if(a.get(j) == 0 && m > 0){ 
                j++;
                m--;
            }
            else{
                if(rj - ri < j - i){
                    rj = j;
                    ri = i;
                }
                i++;
                j = i;
                m = b;
            }
        }
        if(rj - ri < j - i){
            rj = j;
            ri = i;
        }
        for(i = ri ; i < rj ; result.add(i), i++);
        return result;
	}
}
