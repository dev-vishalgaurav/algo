/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 */
public class Solution {
	// DO NOT MODIFY THE LIST
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
         long sum = 0, ssum = 0;
        for(int i = 0 ; i < a.size(); i++){
            long curi = i+1; // importnt to prevent overflow.
            long curn = a.get(i); // importnt to prevent overflow.
            sum += curn - curi;
            ssum +=curn*curn - curi*curi ;
        }
        ssum /= sum; // A + B 
        long first = (sum + ssum)/2;
        long second = (ssum - first); 
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int)first);
        result.add((int)second);
        return result;
    }
}
