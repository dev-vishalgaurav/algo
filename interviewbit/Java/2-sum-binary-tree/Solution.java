/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/2-sum-binary-tree/
 */
public class Solution {
    public int t2Sum(TreeNode a, int b) {
        if(a == null) return 0;
        Stack<TreeNode> left =  new Stack<>();
        Stack<TreeNode> right =  new Stack<>();
        for(TreeNode root = a ; root != null ; left.push(root), root = root.left);
        for(TreeNode root = a ; root != null ; right.push(root), root = root.right);
        TreeNode small = left.peek(), big = right.peek();
        while(small != null && big != null && small.val < big.val){
            long sum = small.val + big.val;
            if(sum == b) return 1;
            else if(sum < b){
                // pop from the left stack and updated its next smallest value;
                left.pop();
                if(small.right != null)
                    for(TreeNode root = small.right ; root != null ; left.push(root), root = root.left);
                if(left.isEmpty()) return 0;
                small = left.peek();
            }else{
                // pop from right stack and updated its next biggest value
                right.pop();
                if(big.left != null)
                    for(TreeNode root = big.left ; root != null ; right.push(root), root = root.right);
                if(right.isEmpty()) return 0;
                big = right.peek();
            }
        }
        return 0;
    }
}
