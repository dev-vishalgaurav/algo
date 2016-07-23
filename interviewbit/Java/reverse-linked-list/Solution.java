/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/reverse-linked-list/
 */
public class Solution {
	public ListNode reverseList(ListNode a) {
	   ListNode tail = null;
	   while(a != null){
	        ListNode next = a.next;
	        a.next = tail;
	        tail = a;
	        a = next;
	   }
	   return tail;
	}
}
