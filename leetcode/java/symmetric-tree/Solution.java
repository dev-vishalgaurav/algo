/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return isEqual(root.left,root.right);
    }
    
    private boolean isEqual(TreeNode p,TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isEqual(p.left,q.right) && isEqual(p.right,q.left);
    }
}