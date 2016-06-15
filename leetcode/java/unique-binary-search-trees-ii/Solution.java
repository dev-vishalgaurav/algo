/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
    
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null); // left/right root is null;
            return result;
        }
        for(int i = start ; i <= end ; i++){
            ArrayList<TreeNode> left = generateTrees(start,i - 1);
            ArrayList<TreeNode> right = generateTrees(i+1,end);
            for(TreeNode leftChild : left)
                for(TreeNode rightChild : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    result.add(root);
                }
        }
        return result;
    }
}