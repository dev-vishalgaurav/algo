/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/path-sum/
 */
public class Solution {
	public int hasPathSum(TreeNode root, int sum) {
	    if(root == null) return 0;
        if(root.left == null && root.right == null && root.val == sum) return 1;
        return hasPathSum(root.left,sum - root.val) == 1 || hasPathSum(root.right,sum - root.val) == 1 ? 1 : 0 ;
	}
}
