/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/next-greater-number-bst/
 */
public class Solution {
	public TreeNode getSuccessor(TreeNode a, int b) {
	    TreeNode root = a;
	    while(a != null){
	        if(b > a.val) a = a.right;
	        else if(b < a.val) a = a.left;
	        else break;
	    }
	    if(a == null) return null; // should never be true;
	    if(a.right != null){ // if there is a right sub tree
	        a = a.right;
	        while(a.left != null) a = a.left; // find the min
	        return a;
	    }else{ // find the next left most ancestor
	        TreeNode successor = null;
	        TreeNode ancestor = root;
	        while(ancestor != a){
	            if(a.val < ancestor.val){
	                successor = ancestor;
	                ancestor = ancestor.left;
	            }else{
	                ancestor = ancestor.right;
	            }
	        }
	        return successor;
	    }
	    
	}
}
