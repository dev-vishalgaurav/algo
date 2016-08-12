/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        return construct(new ListNode[]{head},0, size-1);
    }
    
    private TreeNode construct(ListNode[] head, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode left = construct(head,start,mid-1);
        TreeNode root = new TreeNode(head[0].val);
        root.left = left;
        head[0] = head[0].next;
        root.right = construct(head,mid+1,end);
        return root;
    }
}