/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class Solution {
    /**
     * https://discuss.leetcode.com/topic/50435/java-easy-understandable-bfs-with-priorityqueue 
     */
    class Node implements Comparable<Node>{
        int i, j, val;
        Node(int i , int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        int[][] neighbours = {{1,0},{0,1}};
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        q.offer(new Node(0, 0,nums1[0]+nums2[0]));
        visited[0][0] = true;
        while(!q.isEmpty() && k > 0){
            Node minNode = q.poll();
            for(int[] next : neighbours){
                int i = minNode.i + next[0];
                int j = minNode.j + next[1];
                if(i >= 0 && i < nums1.length && j >=0 && j < nums2.length && !visited[i][j]){
                    visited[i][j] = true;
                    q.offer(new Node(i, j,nums1[i] + nums2[j]));
                }
            }
            int[] curr = {nums1[minNode.i],nums2[minNode.j]};
            result.add(curr);
            k--;
        }
        return result;
    }
}