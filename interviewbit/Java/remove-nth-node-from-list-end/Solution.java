/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 1;
        while(head != null && count < n){
            head = head.next;
            count++;
        }
        if(head == null) return dummy.next.next;
        ListNode tail = dummy;
        while(head.next != null){
            head = head.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
	}
}
