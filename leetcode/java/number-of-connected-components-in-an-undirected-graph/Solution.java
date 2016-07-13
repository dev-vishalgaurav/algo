/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class Solution {
	/**
	 * using union find technique
	 */
	public int countComponents(int n, int[][] edges) {
		// initially there will be n connected components
        int[] uf = new int[n];
        for(int i = 0 ; i < n ; i++){
            uf[i] = i;
        }
        for(int[] edge : edges){
            int p = find(uf,edge[0]), q = find(uf,edge[1]);
            uf[p] = q;
            if(p != q) n--; // it means both p and q were in different sets and we joined them.
        }
        return n;
    }
    /**
	 * returns the root
	 */
    private int find(int[] uf, int node){
        while(node != uf[node]){
            node = uf[node] = uf[uf[node]];
        }
        return node;
    }
	
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])) graph.put(edge[0],new ArrayList<Integer>());
            if(!graph.containsKey(edge[1])) graph.put(edge[1],new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                count++;
                DFS(i,graph,visited);
            }
        }
        return count;
    }
    
    private void DFS(int i,HashMap<Integer,List<Integer>> graph, boolean[] visited){
        visited[i] = true;
        if(graph.containsKey(i)){
            for(Integer next : graph.get(i)){
                if(!visited[next])
                    DFS(next,graph,visited);
            }
        }
    }
	
	/* Using Arrays even slower because of increased complexity */
	public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                count++;
                DFS(i,graph,visited);
            }
        }
        return count;
    }
    
    private void DFS(int i,int[][] graph, boolean[] visited){
        visited[i] = true;
        for (int j = 0 ; j < graph.length ; j++){
            if(graph[i][j] == 1 && !visited[j]){
                DFS(j,graph,visited);
            }
        }
    }
}