/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    if(a == null || a.size() == 0) return a;
        int carry = 1, i = a.size() - 1;
        Stack<Integer> s = new Stack<>();
        while(i >= 0){
          int digit = a.get(i--) + carry;
          carry = digit / 10;
          digit = digit % 10;
          s.push(digit);
        }
        if(carry == 1) s.push(1);
        while(!s.isEmpty() && s.peek() == 0) s.pop();
        ArrayList<Integer> result = new ArrayList<>();
        while(!s.isEmpty())result.add(s.pop());
        return result;
	}
}
