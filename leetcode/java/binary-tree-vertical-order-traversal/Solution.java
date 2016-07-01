/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int[] minMax = {0,0};
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.offer(root); 
        levels.offer(0);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int level = levels.poll();
            if(!map.containsKey(level))
                map.put(level,new ArrayList<Integer>());
            map.get(level).add(cur.val);
            minMax[0] = Math.min(level,minMax[0]);
            minMax[1] = Math.max(level,minMax[1]);
            if(cur.left!=null){
                queue.offer(cur.left);
                levels.offer(level - 1);
            }
            if(cur.right != null){
                queue.offer(cur.right);
                levels.offer(level + 1);
            }
            
        }
        for(int i = minMax[0] ; i <= minMax[1] ; i++){
            result.add(map.get(i));
        }
        return result;
    }
}