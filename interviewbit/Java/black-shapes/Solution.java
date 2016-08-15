/**
 *https://www.interviewbit.com/problems/black-shapes/
 */
public class Solution {
    public int black(ArrayList<String> board) {
        if(board == null || board.size() == 0 || board.get(0).length() == 0) return 0;
        int m = board.size(), n = board.get(0).length();
        boolean[][] visited = new boolean[m][n];
        int count  = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board.get(i).charAt(j) == 'X' && !visited[i][j] ){
                    DFS(i,j,board,m,n,visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(int i, int j ,ArrayList<String> board,int m, int n, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board.get(i).charAt(j) != 'X') return;
        visited[i][j] = true;
        DFS(i+1,j,board,m,n,visited);
        DFS(i-1,j,board,m,n,visited);
        DFS(i,j+1,board,m,n,visited);
        DFS(i,j-1,board,m,n,visited);
    }
}
