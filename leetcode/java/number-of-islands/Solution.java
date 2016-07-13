/**
 * https://leetcode.com/problems/number-of-islands/ 
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    DFS(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    
    private void DFS(char[][] grid,int i, int j, boolean[][] visited ){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        DFS(grid,i+1,j,visited);
        DFS(grid,i-1,j,visited);
        DFS(grid,i,j+1,visited);
        DFS(grid,i,j-1,visited);
    }
}