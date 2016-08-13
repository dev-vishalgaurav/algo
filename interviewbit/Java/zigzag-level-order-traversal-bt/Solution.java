/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	    List<List<Integer>> tempResult = new ArrayList<>();
        traverse(root,tempResult,0);
        // function needed to return ArrayList hence the pain for converting linkedlist to arraylists
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(List<Integer> list : tempResult)
            result.add(new ArrayList<>(list));
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
