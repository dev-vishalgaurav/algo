/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 */
public class Solution {
    public int kthsmallest(TreeNode root, int k) {
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
