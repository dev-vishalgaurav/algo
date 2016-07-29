/**
 * https://www.interviewbit.com/problems/sort-by-color/
 */
public class Solution {
	public void sortColors(ArrayList<Integer> a) {
	    if(a == null || a.isEmpty() || a.size() == 1) return ;
        int i = 0,pivot = 0, j = a.size() - 1;
        while(i <= j){
            if(a.get(i).equals(0)) swap(a,i++,pivot++);
            else if(a.get(i).equals(2)) swap(a, i, j--);
            else i++;
        }
	}
	private void swap(ArrayList<Integer> heap, int from , int to){
        Integer temp = heap.get(from);
        heap.set(from,heap.get(to));
        heap.set(to,temp);
    }
}