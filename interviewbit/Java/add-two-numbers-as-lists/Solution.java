/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = carry;
            ListNode n1 = null, n2 = null;
            if(l1 != null){
                val += l1.val;
                n1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                n2 = l2.next;
            }
            tail.next = new ListNode(val % 10);
            carry = val / 10;
            tail = tail.next;
            l1 = n1;
            l2 = n2;
        }
        if(carry > 0) tail.next = new ListNode(carry);
        return dummy.next;
	}
}
