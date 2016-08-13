/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left =  depth(root.left);
        if(left == -1) return -1;
        int right =  depth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
    
    
}