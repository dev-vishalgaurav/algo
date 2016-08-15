/**
 * https://www.interviewbit.com/problems/word-search-board/
 */
public class Solution {
	public int exist(ArrayList<String> board, String word) {
	    if(board == null || board.size() == 0 || board.get(0).length() == 0 || word == null || word.isEmpty()) return 0;
        int m = board.size() , n = board.get(0).length();
        char[] wordInChar = word.toCharArray();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(DFS(i,j,board,m,n,0,wordInChar)) return 1;
            }
        }
        return 0;
	}
	private boolean DFS(int i , int j , ArrayList<String> board, int m, int n, int index, char[] word){
        if(i < 0 || j < 0 || i >= m || j >= n || index >= word.length || board.get(i).charAt(j) != word[index]) return false;
        return 
               index == word.length - 1 ||
               DFS(i+1, j,board,m,n,index+1,word) || 
               DFS(i-1, j,board,m,n,index+1,word) || 
               DFS(i, j+1,board,m,n,index+1,word) || 
               DFS(i, j-1,board,m,n,index+1,word) ;
    }
}
