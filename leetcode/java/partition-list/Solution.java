/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/partition-list/
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