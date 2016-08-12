/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
 */
public class Solution {
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    if(a == null || a.isEmpty()) return null;
        return constructBST(a, 0, a.size()-1);
	}
	private TreeNode constructBST(List<Integer> a , int start , int end){
        if(start > end || end >= a.size() || start < 0) return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = constructBST(a,start,mid-1);
        node.right = constructBST(a,mid+1,end);
        return node;
    }
}
