/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root!=null)
            return util(root,1);
        return 0;
    }
    
    private int util(TreeNode root,int streak){
        int leftStreak = 0 , rightStreak = 0;
        if(root.left!= null){
            leftStreak = (root.left.val - root.val == 1) ? streak + 1  : 1 ;
            leftStreak = util(root.left,leftStreak);
        }
        if(root.right!= null){
            rightStreak = (root.right.val - root.val == 1) ? streak + 1  : 1 ;
            rightStreak = util(root.right,rightStreak);
        }
        return Math.max(Math.max(leftStreak,rightStreak),streak);
        
    }
}