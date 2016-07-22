/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/list-cycle/
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
