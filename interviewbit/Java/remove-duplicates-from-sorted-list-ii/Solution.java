/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode dummy = new ListNode(0), tail = dummy;
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                int val = head.val;
                while(head != null && head.val == val) head = head.next;
                continue;
            }
            if(head == null) break;
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = null;
        }
        return dummy.next;
	}
}
