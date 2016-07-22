/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/palindrome-list/
 */
public class Solution {
    public int lPalin(ListNode head) {
        if(head == null) return 1;
        // fast is the tail of second half and center is the head of second half.
		// slow is the head of reversed half.	
        ListNode fast = head, slow = head, center = head.next, pre = null ;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = center;
            center = center.next;
            slow.next = pre;
        }
        if(fast.next == null) slow =  slow.next; // odd number of elements shift one from slow head
        while(center != null){
            if(center.val != slow.val) return 0;
            center = center.next;
            slow = slow.next;
        }
        return 1;      
    }
}
