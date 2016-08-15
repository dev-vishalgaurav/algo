/**
 * https://leetcode.com/problems/word-search/
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) return false;
        int m = board.length , n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] wordInChar = word.toCharArray();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(DFS(i,j,board,m,n,0,wordInChar,visited)) return true;
            }
        }
        return false;
    }
    
    private boolean DFS(int i , int j , char[][] board, int m, int n, int index, char[] word, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || index >= word.length || board[i][j] != word[index]) return false;
        if(index == word.length - 1) return true;
        int[][] next = {{1,0},{-1,0},{0,1},{0,-1}};
        visited[i][j] = true;
        for(int[] xy : next){
            if(DFS(i+xy[0], j + xy[1],board,m,n,index+1,word,visited)) return true;
        }
        visited[i][j] = false;
       return false; 
    }
    
}