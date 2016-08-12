/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> a) {
        if(a == null || a.isEmpty()) return null;
        return construct(a, 0, a.size()-1);
    }
    private TreeNode construct(ArrayList<Integer> a, int start, int end){
        if(start > end || start < 0 || end < 0 || start > a.size() || end > a.size()) return null;
        int maxIndex = getMax(a,start,end);
        TreeNode root = new TreeNode(a.get(maxIndex));
        root.left = construct(a,start,maxIndex - 1);
        root.right = construct(a,maxIndex + 1,end);
        return root;
    }
    
    private int getMax(ArrayList<Integer> a, int start, int end){
        int maxIndex = start;
        for(int i = start + 1; i <= end ; i++){
            if(a.get(i) > a.get(maxIndex)){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
