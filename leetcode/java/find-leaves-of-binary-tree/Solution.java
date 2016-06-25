/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	/**
	 * https://leetcode.com/problems/find-leaves-of-binary-tree/
	 */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root!=null){
            addLeaves(root,result);
        }
        return result;
    }
    
    private int addLeaves(TreeNode root, List<List<Integer>> result){
        if(root == null) return -1;
        int depth = Math.max(addLeaves(root.left,result),addLeaves(root.right,result)) + 1;
        if(depth == result.size()){
            result.add(new ArrayList<Integer>());
            root.left = null;
            root.right = null;
        }
        result.get(depth).add(root.val);
        return depth;
    }
}