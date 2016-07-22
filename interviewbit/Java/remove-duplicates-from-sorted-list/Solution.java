/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null) return null;
        ListNode result = head, prev = head;
        head = head.next;
        prev.next = null;
        while(head != null){
            ListNode next = head.next;
            head.next = null;
            if(prev.val != head.val){
                prev.next = head;
                prev = prev.next;
            }
            head = next;
        }
        return result;
	}
}
