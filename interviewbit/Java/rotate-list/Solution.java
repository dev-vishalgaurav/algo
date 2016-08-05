/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/rotate-list/
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
	    if(k == 0 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), tail = dummy, prev = null;
        dummy.next = head;
        int count = 0 ;
        while(head != null){
            count++;
            prev = head;
            head = head.next;
            if(k > 0) k--;
            else tail = tail.next;
        }
        if(tail == dummy) return rotateRight(dummy.next, k % count);
        prev.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
	}
}
