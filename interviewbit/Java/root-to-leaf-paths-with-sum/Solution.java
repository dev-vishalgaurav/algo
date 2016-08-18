/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        find(root,sum,new ArrayList<Integer>(),result);
        return result;
	}
	   private void find(TreeNode root, int sum, ArrayList<Integer> trail, ArrayList<ArrayList<Integer>> result){
        if(root == null) return;
        if(root.left == null && root.right == null){
         if(sum == root.val){
             ArrayList<Integer> list = new ArrayList<>(trail);
             list.add(sum);
             result.add(list);
         }
          return ;   
        }
        if(root.left != null){
            trail.add(root.val);
            find(root.left,sum - root.val,trail,result);
            trail.remove(trail.size()-1);
        }
        if(root.right != null){
            trail.add(root.val);
            find(root.right,sum - root.val,trail,result);
            trail.remove(trail.size()-1);
        }
    }
}
