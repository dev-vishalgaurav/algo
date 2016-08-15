/**
 * https://www.interviewbit.com/problems/capture-regions-on-board/
 */
public class Solution {
	public void solve(ArrayList<ArrayList<Character>> board) {
	    if(board == null || board.size()  == 0 || board.get(0).size() == 0) return;
        int m = board.size(), n = board.get(0).size();
        for(int i = 0 ; i < m ; i++){
            if(board.get(i).get(0) == 'O') DFS(i,0,board,m,n);
            if(board.get(i).get(n-1) == 'O') DFS(i,n-1,board,m,n);
        }
        for(int j = 0 ; j < n ; j++){
            if(board.get(0).get(j) == 'O') DFS(0,j,board,m,n);
            if(board.get(m-1).get(j) == 'O') DFS(m-1,j,board,m,n);
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board.get(i).get(j) == '#') board.get(i).set(j,'O');
                else board.get(i).set(j,'X');
            }
        }
	}
	private void DFS(int i, int j, ArrayList<ArrayList<Character>> board, int m , int n){
	    if(i < 0 || j < 0 || i >= m || j >= n || board.get(i).get(j) != 'O') return;
        board.get(i).set(j,'#');
        if(i < m - 2 && board.get(i+1).get(j) == 'O')  DFS(i+1,j,board,m,n);
        if(i > 0 && board.get(i-1).get(j) == 'O')  DFS(i-1,j,board,m,n);
        if(j < n - 2 && board.get(i).get(j+1) == 'O')  DFS(i,j+1,board,m,n);
        if(j > 0 && board.get(i).get(j-1) == 'O')  DFS(i,j-1,board,m,n);
    }
}