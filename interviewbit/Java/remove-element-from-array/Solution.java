/**
 * https://www.interviewbit.com/problems/remove-element-from-array/
 */
public class Solution {
	/**
	 * this is the simple solution. 
	 */
	public int removeElement(ArrayList<Integer> a, int b) {
        if(a == null || a.isEmpty()) return 0;
        int i = 0,n = a.size();
        for( int j = 0 ; j < n; j++ ){
            if(a.get(j).equals(b)) continue;
            else a.set(i++,a.get(j));
        }
        return i;
	}
	/**
	 * using while loop same as above
	 */
	public int removeElement(ArrayList<Integer> a, int b) {
        if(a == null || a.isEmpty()) return 0;
        int i = 0, j = 0 , n = a.size();
        while( j < n ){
            if(a.get(j).equals(b)) j++;
            else a.set(i++,a.get(j++));
        }
        return i;
	}
	public int removeElement(ArrayList<Integer> a, int b) {
        if(a == null || a.isEmpty()) return 0;
        int i = 0, j = 0,n = a.size();
        while(j < n){
            if( i == j && !a.get(i).equals(b) && !a.get(j).equals(b)) i = ++j;
            else if(a.get(j).equals(b)) j++;
            else if(!a.get(i).equals(b))i++;
            else swap(a,i++, j++);
        }
        return i;
	}
	private void swap(final List<Integer> a, int from, int to){
        Integer temp = a.get(from);
        a.set(from, a.get(to));
        a.set(to, temp);
    }
}
