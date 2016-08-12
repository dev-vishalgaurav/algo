/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode a) {
	    int size = 0;
        ListNode node = a;
        while(node != null){
            size++;
            node = node.next;
        }
        return construct(new ListNode[]{a},0, size-1);
	    
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
