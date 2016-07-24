/**
 * https://leetcode.com/problems/game-of-life/
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++){
                int lives = getLives(i,j,board);
                if(board[i][j] == 1 && (lives < 2 || lives > 3)) board[i][j] = 2;
                else if(board[i][j] == 0 && lives == 3) board[i][j] = -1;
            }
         for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == -1) board[i][j] = 1;
                else if(board[i][j] == 2) board[i][j] = 0;
            }
    }
    
    private int getLives(int i, int j, int[][] board){
        int[][] neighbours = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1}};
        int count = 0;
        for(int[] n : neighbours){
            int i1 = n[0] + i, j1 = n[1] + j;
            if(i1 >=0 && i1 < board.length && j1 >= 0 && j1 < board[0].length && board[i1][j1] >= 1 ) count++;
        }
        return count;
    }
}