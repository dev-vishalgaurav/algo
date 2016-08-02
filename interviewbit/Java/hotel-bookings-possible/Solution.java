/**
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 */
public class Solution {
    public boolean hotel(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
        if(a== null || b == null || a.isEmpty() || b.isEmpty() || k == 0) return false; 
        int i = 1, j = 0, total = 1, n = a.size();
        Collections.sort(a);
        Collections.sort(b);
        while(i < n && j < n){
            if(a.get(i) < b.get(j)){
                i++;
                if(++total > k) return false;
            }else{
                j++;
                total--;
            }
        }
        return true;
    }
}
