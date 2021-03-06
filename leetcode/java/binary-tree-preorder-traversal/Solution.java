/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {
	/**
	 * O(n) space
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode parent = stack.pop();
            result.add(parent.val);
            if(parent.right!=null) stack.push(parent.right);
            if(parent.left!=null) stack.push(parent.left);
        }
        return result;
    }
	/**
	 * O(1) Space using Morris traversal
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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