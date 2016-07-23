/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    if(a == null || b == null) return null;
	    int lenA = 0 ,lenB = 0, diff = 0;
	    ListNode headA = a, headB = b;
	    while(headA.next != null && lenA++ >= 0) headA = headA.next;
	    while(headB.next != null && lenB++ >= 0) headB = headB.next;
	    if(headA != headB)  return null;
	    ListNode[] heads = (lenA >= lenB) ? new ListNode[]{a,b} : new ListNode[]{b,a}; 
	    diff = Math.abs(lenA-lenB);
	    while(diff-- > 0) heads[0] = heads[0].next;
	    while(heads[0] != heads[1]){
	        heads[0] = heads[0].next;
	        heads[1] = heads[1].next;
	    }
	    return heads[0];        
    }
}