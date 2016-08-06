/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/valid-binary-search-tree/
 */
public class Solution {
	public int isValidBST(TreeNode a) {
	    return isValid(a,(long)(Integer.MIN_VALUE) - 1l,(long)(Integer.MAX_VALUE) + 1l) == true ? 1 : 0;
	}
	
	public boolean isValid(TreeNode a , long min , long max){
	    if(a == null) return true;
	   return (a.val > min && a.val < max) && isValid(a.left,min,a.val) && isValid(a.right,a.val,max) ;
	    
	}
}
