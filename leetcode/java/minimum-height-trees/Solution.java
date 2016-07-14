/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n == 1) {
            leaves.add(0);
            return leaves;
        }
        List<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ;i++) graph.add(new HashSet<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i = 0 ; i < n ; i++){
            if(graph.get(i).size() == 1) leaves.add(i);
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> nextLevel = new ArrayList<>();
            for(int i : leaves){
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if(graph.get(j).size() == 1) nextLevel.add(j);
            }
            leaves = nextLevel;
        }
        return leaves;
    } 
}