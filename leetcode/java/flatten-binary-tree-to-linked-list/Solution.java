/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flattenRoot(root);
    }
    
    private TreeNode flattenRoot(TreeNode root){
        if(root == null) return null;
        TreeNode last = root, left = root.left, right = root.right;
        root.left = root.right = null;
        if(left != null){
            last = flattenRoot(left);
            root.right = left;
        }
        if(right != null){
            last.right = right;
            last = flattenRoot(right);
        }
        return last;
    }
	/**
	 * Using morris traversal
	 */
	public TreeNode flattenBinaryTreeInorder(TreeNode a){
        TreeNode dummy = new TreeNode(0);
        TreeNode tail = dummy;
        while(a != null){
            if(a.left == null){
                TreeNode next = a ;
                a = a.right;
                next.left = null;
                tail.right = next;
                tail = tail.right;
            }else{
                TreeNode rightMost = a.left;
                while(rightMost.right != null && rightMost.right != a) 
                    rightMost = rightMost.right;
                if(rightMost.right == a){
                    TreeNode next = a ;
                    a = a.right;
                    next.left = null;
                    tail.right = next;
                    tail = tail.right;
                }else{
                    rightMost.right = a;
                    a = a.left;
                }
            }
        }
        return dummy.right;
    }
}