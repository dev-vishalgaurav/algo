/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/reorder-list/
 */
public class Solution {
	public ListNode reorderList(ListNode head) {
	    if(head == null) return head;
        ListNode fast = head, slow = head, center = head.next, pre = head, mid = null, next = null;
        /**
         * following loop divides the list into 2 halves and reverse the first half;
         */
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = center;
            center = center.next;
            slow.next = pre;
        }
        if(fast.next == null){ // if list is of odd length then move next in first half and store the last value.
            mid = slow;
            slow = slow.next;
            mid.next = null;
        }
        /**
         * merge the 2 halves
         */
        while(center != null){
            pre = slow.next;
            next = center.next;
            center.next = slow.next = null;
            slow.next = center;
            center.next = mid;
            mid = slow; // store this have a reference of the tail;
            center = next;
            slow = pre;
        }
        return head;
	}
}
