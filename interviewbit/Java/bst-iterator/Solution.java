/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/bst-iterator/
 */

public class Solution {
    private Stack<TreeNode> stack = null;
    private TreeNode root = null;

    public Solution(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        updateStack(root);
    }
    private void updateStack(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
       TreeNode node = stack.pop();
       TreeNode last = node.right;
       updateStack(last);
       return node.val;        
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
