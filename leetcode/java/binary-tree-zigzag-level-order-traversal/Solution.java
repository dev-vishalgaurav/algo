/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root,result,0);
        return result;
    }
    
    private void traverse(TreeNode root,List<List<Integer>> result,int level){
        if(root == null) return;
        if(result.size() == level) result.add(new LinkedList<>());
        LinkedList<Integer> list = (LinkedList<Integer>)result.get(level);
        if(level % 2 == 0) list.addLast(root.val);
        else list.addFirst(root.val);
        traverse(root.left,result,level+1);
        traverse(root.right,result,level+1);
    }
}