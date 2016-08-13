/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {
	public TreeNode flatten(TreeNode a) {
	    if(a == null) return a;
	    flattenRoot(a);
	    return a;
	}
	/**
	 * Takes space equivalent to recursion depth
	 */
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
	public TreeNode flatten(TreeNode a) {
	    TreeNode root = a;
	    while(root != null){
           if(root.left != null){
               TreeNode rightMost = root.left;
               while(rightMost.right != null) 
                    rightMost =  rightMost.right;
               rightMost.right = root.right;
               root.right = root.left;
               root.left = null;
	}
}
