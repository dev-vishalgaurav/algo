/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
	    ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head != null){
            if(head.next == null){
                tail.next = head;
                break;
            }
            ListNode next = head.next.next;
            head.next.next = head; // reset
            tail.next = head.next;
            head.next = null;
            tail = head;
            head = next;
        }
        return dummy.next;
	}
}
