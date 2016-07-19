/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode root = null;
        while(head != null){
            ListNode next = head.next;
            head.next = null;
            if(root == null)
                root = head;
            else{
                head.next = root;
                root = head;
            }
            head = next;    
        }
        return root;
    }
}