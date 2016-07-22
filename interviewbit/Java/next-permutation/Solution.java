/**
 * https://www.interviewbit.com/problems/next-permutation/
 */
public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
        if(a == null || a.size() <= 1)  return;
        int i = a.size() - 1;
        while(i > 0){
            if(a.get(i-1) < a.get(i)){
                int k = i, j = i, num = a.get(i-1), min = a.get(i);
                while(j < a.size()){
                    if(a.get(j) > num && a.get(j) < min){
                        min = a.get(j);
                        i = j;
                    }
                    j++;
                }
                swap(a,k-1,i);
                Collections.sort(a.subList(k, a.size()));
                return ;
            }
            i--;
        }
        Collections.sort(a);
        return ;
	}
    private void swap(final List<Integer> a, int from, int to){
        int temp = a.get(from);
        a.set(from, a.get(to));
        a.set(to, temp);
    }
}
