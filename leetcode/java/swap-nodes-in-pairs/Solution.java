/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head != null){
            if(head.next == null){
                tail.next = head;
                break;
            }
            ListNode next = head.next.next;
            head.next.next = head; // reset
            tail.next = head.next;
            head.next = null;
            tail = head;
            head = next;
        }
        return dummy.next;
    }
}