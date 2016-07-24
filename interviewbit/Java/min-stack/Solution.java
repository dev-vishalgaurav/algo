/**
 * https://www.interviewbit.com/problems/min-stack/
 */
class Solution {
    class Node{
        int val;
        int min;
        Node(int val, int min){
            this.val = val; 
            this.min = min;
        }
    }
    Stack<Node> s = new Stack<>();
    public void push(int x) {
        s.push(new Node(x,(s.isEmpty() ? x : Math.min(x, s.peek().min))));
    }

    public void pop() {
        if(!s.isEmpty()) s.pop();
    }

    public int top() {
        return s.isEmpty() ? -1 : s.peek().val;
    }

    public int getMin() {
        return s.isEmpty() ? -1 : s.peek().min;
    }
}
