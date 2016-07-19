/**
 * https://leetcode.com/problems/walls-and-gates/
 */
public class Solution {
	/**
	 * Using DFS 
	 */
	public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                if(rooms[i][j] == 0)
                    DFS(i,j,rooms,m,n,0);
    }
    
    private void DFS(int i , int j, int[][] rooms, int m, int n, int d){
        if( i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] == -1 ||rooms[i][j] < d ) return;
        rooms[i][j] = d;
        DFS(i+1,j,rooms,m,n,d + 1);
        DFS(i-1,j,rooms,m,n,d + 1);
        DFS(i,j + 1,rooms,m,n,d + 1);
        DFS(i,j - 1,rooms,m,n,d + 1);
    }
	
	/**
	 * Using BFS 
	 */
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(rooms[i][j] == 0){
                    BFS(i,j,rooms,m,n);
                }
            }
        }
    }
    
    private void BFS(int i , int j, int[][] rooms, int m, int n){
        int[][] neighbours = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Integer[]> q = new ArrayDeque<>();
        Integer[] root = {i,j};
        q.offer(root);
        while(!q.isEmpty()){
            Integer[] p = q.poll();
            int x = p[0], y = p[1];
            for(int[] neighbour : neighbours){
                int x1 = x + neighbour[0], y1 = y + neighbour[1];
                if(x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || rooms[x1][y1] == -1 || rooms[x][y] + 1 > rooms[x1][y1]) 
                    continue;
                rooms[x1][y1] = rooms[x][y] + 1;
                Integer[] next = {x1,y1};
                q.offer(next);
                
            }
        }
    }
}