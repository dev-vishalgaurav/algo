/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode root = null, tail = null;
        while(head != null){
            boolean isUnique = true;
            int val = head.val;
            ListNode next = head.next;
            while(next != null && next.val == val){
                isUnique  = false;;
                next = next.next;
            }
            if(isUnique){
                if(root == null){
                    root = tail = head;
                }else{
                    tail.next = head;
                    tail = tail.next;
                }
                tail.next = null;
            }
            head = next;
        }
        return root;
    }
}