/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/rotate-list/
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode root = head, headR = head;
        while(k > 0){
            int len = 0, prevK = k;
            while(head != null && k > 0){
                k--;
                head = head.next;
                len++;
            }
            if(k > 0){
                k = prevK % len;
                head = root;
            }
        }
        if(head != null && k == 0){
            while(head.next != null){
                head = head.next;
                headR = headR.next;
            }
            head.next = root;
            root = headR.next;
            headR.next = null;
        }
        return root;    
    }
	public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), tail = dummy, prev = null;
        dummy.next = head;
        int count = 0 ;
        while(head != null){
            count++;
            prev = head;
            head = head.next;
            if(k > 0) k--;
            else tail = tail.next;
        }
        if(tail == dummy) return rotateRight(dummy.next, k % count);
        prev.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}