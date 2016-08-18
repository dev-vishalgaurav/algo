/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class Solution {
    
    ListNode head = null;
    Random r = null;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        r = new Random(System.currentTimeMillis());
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head.next, result = head;
        for(int n = 2 ; node != null ; node = node.next, n++)
            if(r.nextInt() % n == 0) result = node;     
        return result.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */