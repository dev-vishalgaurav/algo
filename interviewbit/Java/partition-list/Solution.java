/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/partition-list/
 */
public class Solution {
	public ListNode partition(ListNode head, int val) {
	   if(head == null ) return head;
       ListNode dummyL = new ListNode(0), dummyS = new ListNode(0);
       ListNode tailL = dummyL, tailS = dummyS;
       while(head != null){
           ListNode next = head.next;
           head.next = null;
           if(head.val < val){
               tailS.next = head;
               tailS = tailS.next;
           }else{
               tailL.next = head;
               tailL = tailL.next;
           }
           head = next;
       }
       tailS.next = dummyL.next;
       return dummyS.next;
	}
}
