/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> front = new Stack<>();
    Stack<Integer> back = new Stack<>();
    int firstInFront = 0;
    public void push(int x) {
        if(front.isEmpty())
            firstInFront = x;
        front.push(x);
    }
    
    private void shiftToBack(){
        int frontSize = front.size();
        for(int i = 0 ; i < frontSize ; i++){
            back.push(front.pop());
        }
    }
    // Removes the element from in front of queue.
    public void pop() {
        if(back.isEmpty()){
            shiftToBack();
        }
        back.pop();
    }

    // Get the front element.
    public int peek() {
        if(!back.isEmpty()){
            return back.peek();
        }
        return firstInFront;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return front.isEmpty() && back.isEmpty();
    }
}