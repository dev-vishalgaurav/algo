/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] result = new int[n], count = {0}, status = new int[n];
        for(int i = 0 ; i < n; i++)
            graph.add(new ArrayList<Integer>());
        for(int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        for(int i = 0 ; i < n; i++)
            if(status[i] == 0 && ! DFS(i,graph,status,result,count))
                return new int[0];
        return result;        
    }
    private boolean DFS(int n, List<List<Integer>> graph, int[] status,int[] result, int[] count){
        if(status[n] == 1) return false;
        status[n] = 1;
        for(Integer next : graph.get(n))
            if(status[next]!= 2 && !DFS(next,graph,status,result,count)) return false;
        result[count[0]++] = n; 
        status[n] = 2;
        return true;
    }
}