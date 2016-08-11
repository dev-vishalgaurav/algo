/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/preorder-traversal/
 */
public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode rightMost = cur.left;
                while(rightMost.right != null && rightMost.right != cur) rightMost = rightMost.right;
                if(rightMost.right == cur){
                    rightMost.right = null;
                    cur = cur.right;
                }else{
                    result.add(cur.val);
                    rightMost.right = cur;
                    cur = cur.left;
                }
            }
        }
        return result;
	}
}
