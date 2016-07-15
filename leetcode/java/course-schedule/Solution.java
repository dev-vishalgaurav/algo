/**
 * https://leetcode.com/problems/course-schedule/
 */
public class Solution {
    public boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(); 
        int[] status = new int[n];
        for(int i = 0 ; i < n; i++)
            graph.add(new ArrayList<Integer>());
        for(int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        for(int i = 0 ; i < n; i++)
            if(status[i] == 0 && ! DFS(i,graph,status))
                return false;
        return true;
    }
    
    private boolean DFS(int n, List<List<Integer>> graph, int[] status){
        if(status[n] == 1) return false;
        status[n] = 1;
        for(Integer next : graph.get(n))
            if(!DFS(next,graph,status)) return false;
        status[n] = 2;
        return true;
    }
}