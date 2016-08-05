/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 1;
        while(head != null && count < n){
            head = head.next;
            count++;
        }
        ListNode tail = dummy;
        while(head.next != null){
            head = head.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }
}