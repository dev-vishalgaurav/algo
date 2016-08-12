/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class Solution {
	/**
	 * Using recursion 
	 */
	public int kthSmallest(TreeNode root, int k) {
        int[] result = {0,0};
        helper(root,k,result);
        return result[1];
    }
    
    public void helper(TreeNode root, int k, int[] result){
        if(root == null) return;
        helper(root.left,k,result);
        if(result[0] == k-1 ){
            result[0]++;
            result[1] = root.val;
            return;
        }
        if(result[0] >= k ) return ;
        result[0]++;
        helper(root.right,k,result);
    }
	/**
	 * Using Morris traversal. O(n) time and O(1) space
	 */
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        while(root != null){
            if(root.left == null){
                count++; // visit node
                if(count == k) return root.val; // check for succuess
                root = root.right;
            }else{
                // get the rightmost child of left subtree and connect it with current i.e root
                TreeNode node = root.left;
                while(node.right != null && node.right != root) node = node.right;
                if(node.right == root){
                    node.right = null; // remove temporary cycle
                    count++; // visit node
                    if(count == k) return root.val; // check for success
                    root = root.right;
                }else{
                    node.right = root; // connect to form a temorary cycle
                    root = root.left;
                }
            }
        }
        return Integer.MIN_VALUE;
    }
    
}