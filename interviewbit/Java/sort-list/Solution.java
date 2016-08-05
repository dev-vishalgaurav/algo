/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/sort-list/
 */
public class Solution {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        return mergeSort(head);	    
	}
	private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode[] halves = partition(head);
        return merge(mergeSort(halves[0]),mergeSort(halves[1]));
    }
    private ListNode[] partition(ListNode head){
        ListNode root = head, slow = head, center = head.next, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            center = center.next;
        }
        slow.next = null;
        return new ListNode[]{root,center};
    }
    public ListNode merge(ListNode l1, ListNode l2) {
       if(l1 == null) return l2;
       if(l2 == null) return l1;
	   ListNode dummy = new ListNode(0), tail = dummy;
        while(l1 != null || l2 != null){
            ListNode cur = null;
            if(l2 == null || (l1 != null && l1.val <= l2.val) ){
                cur = l1;
                l1 = l1.next;
            }else{
                cur = l2;
                l2 = l2.next;
            }
            tail.next = cur;
            tail = tail.next;
        }
        return dummy.next;
	}
}
