/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/intersection-of-linked-lists/
 */
public class Solution {
	/**
	 * shorter version
	 */
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
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    if(a == null || b == null) return null;
	    int lenA = 0 ,lenB = 0;
	    ListNode headA = a, headB = b;
	    while(headA.next != null){
	        lenA++;
	        headA = headA.next;
	    }
	    while(headB.next != null){
	        lenB++;
	        headB = headB.next;
	    }
	    if(headA != headB)  return null;
	    int diff = 0;
	    ListNode longer = null, shorter = null;
	    if(lenA >= lenB){
	        longer = a;
	        shorter = b;
	        diff = lenA - lenB;
	    }else{
	        longer = b;
	        shorter = a;
	        diff = lenB - lenA;
	    }
	    while(diff-- > 0) longer = longer.next;
	    while(longer != shorter){
	        longer = longer.next;
	        shorter = shorter.next;
	    }
	    return longer;
	}
}
