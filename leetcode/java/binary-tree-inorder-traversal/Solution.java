/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode rightMost = cur.left;
				// connect the rightMost child of left node with current node
                while(rightMost.right != null && rightMost.right != cur) rightMost = rightMost.right;
                if(rightMost.right == cur){
                    rightMost.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }else{
                    rightMost.right = cur;
                    cur = cur.left;
                }
            }
        }
        return result;
    }
}