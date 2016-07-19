/**
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class Solution {
	/**
	 * using union find  
	 */
    public boolean validTree(int n, int[][] edges) {
       int[] uf = new int[n];
       for(int i = 0 ; i < n ; i++){
           uf[i] = i;
       }
       int trees = edges.length;
       int prev = -1;
       for(int[] edge : edges){
           int p = find(uf,edge[0]), q = find(uf,edge[1]);
           uf[p] = q;
           if(p==q) return false;
       }
       return edges.length == n-1;
    }
    
    private int find(int[] uf, int node){
        while(node != uf[node])
            node = uf[node] = uf[uf[node]];
        return node;
    }
}