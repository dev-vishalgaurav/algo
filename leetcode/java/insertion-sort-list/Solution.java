/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;
        while(head != null){
            ListNode next = head.next , ins = dummy.next, prev = dummy;
            head.next = null;
            if(head.val >= tail.val){
                tail.next = head;
                tail = head;
            }else if(ins.val >= head.val ){
                head.next = dummy.next;
                dummy.next = head;
            }else{
                while(ins != null && head.val >= ins.val){
                    prev = ins;
                    ins = ins.next;  
                }
                head.next = prev.next;
                prev.next = head;
            }
           head = next;
        }
        return dummy.next;
    }
}