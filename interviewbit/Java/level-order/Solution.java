/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/level-order/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    temp.offer(node.left);
                }
                if(node.right!=null){
                    temp.offer(node.right);
                }
            }
            queue.addAll(temp);
            temp.clear();
            result.add(level);
        }
        return result;
	}
}
