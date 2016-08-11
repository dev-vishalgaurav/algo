/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            if(node != null){
             stack.push(node);
             node = node.left;
            }else{
                if(stack.peek().right == null){
                    TreeNode temp = stack.pop();
                    result.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                }else
                    node = stack.peek().right;
                
            }
        }
        return result;
    }
}