/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/identical-binary-trees/
 */
public class Solution {
	public int isSameTree(TreeNode p, TreeNode q) {
	    if(p == null && q == null) return 1;
        if(p == null || q == null) return 0;
        return (p.val == q.val && (isSameTree(p.left,q.left) == isSameTree(p.right,q.right))) ? 1 : 0;
	}
}
