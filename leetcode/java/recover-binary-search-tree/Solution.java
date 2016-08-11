/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        List<TreeNode> list = new ArrayList<>();
        // doing in order traversal using morris method. O(1) space
        while(cur != null){
            if(cur.left == null){
                check(prev,cur,list);
                prev = cur;
                // visit node
                cur = cur.right;
            }else{
                TreeNode rightMost = cur.left;
                while(rightMost.right != null && rightMost.right != cur) rightMost = rightMost.right;
                if(rightMost.right == cur){
                    rightMost.right = null;
                    check(prev,cur,list);
                    prev = cur;
                    // visit node
                    cur = cur.right;
                }else{
                    rightMost.right = cur;
                    cur = cur.left;
                }
            }
        }
        if(list.size() > 1)
            swap(list.get(0),list.get(1));
    }
    private void swap(TreeNode prev, TreeNode cur){
        int temp = prev.val;
        prev.val = cur.val;
        cur.val = temp;
    }
    private void check(TreeNode prev, TreeNode cur, List<TreeNode> list){
        if(prev == null) return;
        if(prev.val > cur.val && list.size() == 0){
            list.add(prev);
            list.add(cur); // adding cur also for special case of only 2 nodes.
        }else if(prev.val > cur.val){
            list.set(1,cur);
        }
    }
    
    
}