/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 */
public class Solution {
	public int sumNumbers(TreeNode a) {
	    return sum(a,0);
	}
	private int sum(TreeNode root, int num){
        if(root == null) return 0;
        num = (((num * 10) % 1003)  + (root.val % 1003)) % 1003;
        if(root.left == null && root.right == null){
            return num;
        }
        return ((sum(root.left,num) % 1003) + (sum(root.right,num) % 1003)) % 1003;
    }
}
