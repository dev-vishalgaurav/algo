/**
 * https://www.interviewbit.com/problems/wave-array/
 */
public class Solution {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	   int n = a.size(), i = 0;
	   Collections.sort(a);
	   while(i < n - 1){
	        swap(a,i++,i++);
	   }
       return a;
	}
	private void swap(ArrayList<Integer> list, int from , int to){
        Integer temp = list.get(from);
        list.set(from,list.get(to));
        list.set(to,temp);
    }
}
