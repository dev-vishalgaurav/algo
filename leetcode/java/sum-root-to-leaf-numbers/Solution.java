/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null){
          int result = root.val;
          root.val = root.val % 10; // backtracking 
          return result;  
        } 
        root.val *= 10;
        int sum = 0;
        if(root.left != null){
            root.left.val = root.val + root.left.val;
            sum += sumNumbers(root.left);
        }
        if(root.right != null){
            root.right.val = root.val + root.right.val;
            sum += sumNumbers(root.right);
        } 
        root.val /= 10; // backtracking  
        
        return sum;
    }
    
    
}