/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
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
            if(center.val != slow.val) return false;
            center = center.next;
            slow = slow.next;
        }
        return true;      
    }
}