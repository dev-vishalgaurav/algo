/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class Solution {
   /**
    * Using String builder
    */
   public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        build(root,sb,result);
        return result;
    }
    
    private void build(TreeNode root,StringBuilder sb, List<String> result){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result.add(sb.toString() + root.val);
            return;
        }
        int len = sb.length();
        sb.append(""+root.val +"->");
        build(root.left,sb,result);
        sb.delete(len, sb.length());
        sb.append(""+root.val +"->");
        build(root.right,sb,result);
        sb.delete(len, sb.length());
    }
	/**
     * Using String
     */
	 
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String sb = "";
        build(root,sb,result);
        return result;
    }
    
    private void build(TreeNode root,String sb, List<String> result){
        if(root == null) return;
        if(root.left == null && root.right == null)
            result.add(sb + "" + root.val);
        else{
            build(root.left,sb + ""+root.val +"->",result);
            build(root.right,sb + ""+root.val +"->",result);
        }
    }
}