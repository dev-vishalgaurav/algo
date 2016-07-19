/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */
public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return -1;
        int dist = Integer.MAX_VALUE, house = 0, m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){ 
                    BFS(i,j,grid,count);
                    house++;
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
           for(int j = 0 ; j < n ; j++){
                if(grid[i][j] > 2 && count[i][j] == house){
                    dist = Math.min(grid[i][j] - 2*house,dist);
                }                
            }
        }
        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
    
    private void BFS(int i, int j, int[][] grid, int[][] count){
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] neighbours = {{1,0},{-1,0},{0,1},{0,-1}}; 
        Queue<int[]> q =  new LinkedList<>();
        q.offer(new int[]{i,j});
        int level = 2;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int k = 0 ; k < size ; k++){
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for(int[] next : neighbours){
                    int x1 = x + next[0], y1 = y + next[1];
                    if(x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1 || grid[x1][y1] == 2 || visited[x1][y1]) continue;
                    grid[x1][y1] += level  ;
                    count[x1][y1]++;
                    visited[x1][y1] = true;
                    q.offer(new int[]{x1,y1});
                }
            }
        }
    }
	/**
	 * using 2 queues
	 */
	private void BFS1(int i, int j, int[][] grid, int[][] count){
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] neighbours = {{1,0},{-1,0},{0,1},{0,-1}}; 
        Queue<Integer[]> q =  new ArrayDeque<>();
        Queue<Integer> dq =  new ArrayDeque<>();
        Integer[] root = {i,j};
        q.offer(root);
        dq.offer(2);
        while(!q.isEmpty()){
            int d = dq.poll();
            Integer[] p = q.poll();
            int x = p[0], y = p[1];
            for(int[] next : neighbours){
                int x1 = x + next[0], y1 = y + next[1];
                if(x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1 || grid[x1][y1] == 2 || visited[x1][y1]) continue;
                grid[x1][y1] += (d + 1)  ;
                count[x1][y1]++;
                visited[x1][y1] = true;
                Integer[] rootn = {x1,y1};
                q.offer(rootn);
                dq.offer(d+1);
            }
        }
    }
}