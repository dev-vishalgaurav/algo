/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/least-common-ancestor/
 */
public class Solution {
	public int lca(TreeNode a, int val1, int val2) {
        ArrayList<TreeNode> list = new ArrayList<>();
        find(a,val1,val2,list);
        if(list.size() == 2){
            TreeNode result = utils(a,val1,val2);
            if(result != null) return result.val;
        }
        return -1;
	}
	
	private void find(TreeNode root, int val1, int val2, List<TreeNode> list){
	    if(root == null || list.size() == 2) return;
	    if(root.val == val1) list.add(root);
	    if(root.val == val2) list.add(root);
	    find(root.left,val1,val2,list);
	    find(root.right,val1,val2,list);
	}
	
	private TreeNode utils(TreeNode a, int val1, int val2 ){
	    if(a == null || a.val == val1 || a.val == val2) return a;
	    TreeNode left = utils(a.left,val1,val2);
	    TreeNode right = utils(a.right,val1,val2);
	    if(left == null && right == null) return null;
	    if(left == null) return right;
	    if(right == null) return left;
	    return a;
	}
}
