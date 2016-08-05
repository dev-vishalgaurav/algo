/**
 * https://leetcode.com/problems/design-phone-directory/
 */
public class PhoneDirectory {
    private int max = 0;
    private boolean[] map = null;
    LinkedList<Integer> list = null;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        map = new boolean[max];
        list = new LinkedList<>();
        for(int i = 0 ; i < max ; i++){
            list.addLast(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(list.isEmpty()) return -1;
        map[list.peekFirst()] = true;
        return list.pollFirst();
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number < max && !map[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(number < max && map[number]){
            map[number] = false;
            list.addLast(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */