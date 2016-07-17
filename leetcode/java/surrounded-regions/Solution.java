/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Solution {
	
	/**
	 * Without stackoverflow error . Idea is to do DFS only from borders.
	 */
	public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0 || board.length < 2 || board[0].length < 2 ) return;
        int m = board.length, n = board[0].length;
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O') DFS(i,0,board,m,n);
            if(board[i][n-1] == 'O') DFS(i,n-1,board,m,n);
        }
        for(int j = 0 ; j < n ; j++){
            if(board[0][j] == 'O') DFS(0,j,board,m,n);
            if(board[m-1][j] == 'O') DFS(m-1,j,board,m,n);
        }
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
	
    private void DFS(int i, int j, char[][] board, int m , int n){
        board[i][j] = '#';
        if(i < m - 2 && board[i+1][j] == 'O')  DFS(i+1,j,board,m,n);
        if(i > 0 && board[i-1][j] == 'O')  DFS(i-1,j,board,m,n);
        if(j < n - 2 && board[i][j+1] == 'O')  DFS(i,j+1,board,m,n);
        if(j > 0 && board[i][j-1] == 'O')  DFS(i,j-1,board,m,n);
    }
	/**
	* Using DFS not accepted. StackOverflow error.
	*/
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            if(i == 0 || i == board.length - 1 ) continue;
            for(int j = 0 ; j < board[0].length ; j++){
                if(j == 0 || j == board[0].length - 1 ) continue;
                if(board[i][j] == 'O' && !visited[i][j]){
                    DFS(i,j,board,visited);
                }
            }
        }
    }
    
    private boolean DFS(int i, int j, char[][] board,boolean[][] visited){
        int[][] neighbours = {{1,0},{-1,0},{0,1},{0,-1}};
        visited[i][j] = true;
        if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length -1) return false;
        for(int[] n : neighbours){
            int i1 = i + n[0] , j1 = j + n[1];
            if(i1 < 0 || i1 >= board.length || j1 < 0 || j1 >= board[0].length  || board[i1][j1] != 'O' || visited[i1][j1]) continue;
            if(!DFS(i1,j1,board,visited)) return false;
        }
        board[i][j] = 'X';
        return true;
    }
}