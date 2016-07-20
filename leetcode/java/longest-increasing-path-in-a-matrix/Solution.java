/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */ 
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, max = 1;
        int[][] dist = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                max = Math.max(max,DFS(i,j,matrix,m,n,dist));
            }
        }
        return max;
    }
    
    private int DFS(int i, int j, int[][] matrix,int m, int n, int[][] dist){
        if(dist[i][j] != 0) return dist[i][j];
        int max = 1;
        int[][] next = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] ij : next){
            int i1 = i + ij[0], j1 = j + ij[1];
            if(i1 < 0 || i1 >= m || j1 < 0 || j1 >= n || matrix[i1][j1] <= matrix[i][j]) continue ;
            max = Math.max(max, 1 + DFS(i1,j1,matrix,m,n,dist));
        }
        dist[i][j] = max;
        return max;
    }
}