/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast != null ){
            fast = fast.next;
            if(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            if(slow == fast) break;
        }
        if(fast == null) return null;
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}