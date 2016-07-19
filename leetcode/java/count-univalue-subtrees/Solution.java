/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/count-univalue-subtrees/
 */
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        return count(root)[0];
    }
    private int[] count(TreeNode root){
        if(root == null) return new int[]{0,0};
        if(root.left == null && root.right == null) return new int[]{1,root.val};
        int[] left = count(root.left);
        int[] right = count(root.right);
        if((root.left == null || root.val == left[1]) && (root.right == null || root.val == right[1]))
            return new int[]{left[0] + right[0] + 1,root.val};
        return new int[]{left[0] + right[0],Integer.MIN_VALUE};        
    } 
}
