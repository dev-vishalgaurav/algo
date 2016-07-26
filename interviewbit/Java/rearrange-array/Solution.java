/**
 * https://www.interviewbit.com/problems/rearrange-array/
 */
public class Solution {
	public void arrange(ArrayList<Integer> a) {
	   int len = a.size();
        for(int i = 0 ; i < a.size() ; i++){
            int cur = a.get(i);
            a.set(i,cur + (a.get(cur)% len) * len);
        }
        for(int i = 0 ; i < a.size() ; i++){
            int cur = a.get(i);
            a.set(i,cur/len);
        }
	}
}
