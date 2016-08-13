/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/symmetric-binary-tree/
 */
public class Solution {
	public int isSymmetric(TreeNode root) {
	    if(root == null || (root.left == null && root.right == null)) return 1;
        return isEqual(root.left,root.right) == true ? 1 : 0;
	}
	private boolean isEqual(TreeNode p,TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isEqual(p.left,q.right) && isEqual(p.right,q.left);
    }
}
