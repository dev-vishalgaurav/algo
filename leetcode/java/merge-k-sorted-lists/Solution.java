/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeLists(lists,0,lists.length -1);
    }
    public ListNode mergeLists(ListNode[] lists, int lo, int hi){
        if(lo == hi) return lists[lo];
        int mid = lo + (hi - lo)/2;
        return mergeTwoList(mergeLists(lists,lo,mid),mergeLists(lists,mid+1,hi));
    }
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
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