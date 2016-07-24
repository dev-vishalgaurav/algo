/**
 * https://www.interviewbit.com/problems/nearest-smaller-element
 */
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
        if(a == null || a.isEmpty()) return a;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(Integer num : a){
            while(!s.isEmpty() && s.peek() >= num) s.pop();
            result.add(s.isEmpty()  ? -1 : s.peek());
            s.push(num);
        }
        return result;
    }
}
