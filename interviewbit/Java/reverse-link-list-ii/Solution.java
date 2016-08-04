/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 */
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
	    if(m == n) return head;
        ListNode dummy = new ListNode(0);
        ListNode dt = dummy;
        int count = 1;
        while(count < m){
            dt.next = head;
            head = head.next;
            dt = dt.next;
            count++;
        }
        ListNode rh = head, rt = head;
        while(count <= n){
            ListNode next = head.next;
            head.next = null;
            head.next = rh;
            rh = head;
            head = next;
            count++;
        }
        dt.next = rh;
        rt.next = head;
        return dummy.next;
	}
}
