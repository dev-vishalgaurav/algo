/**
 * https://www.interviewbit.com/problems/sudoku/
 */
public class Solution {
	public void solveSudoku(ArrayList<ArrayList<Character>> board) {
	    if(board == null || board.size() < 8  || board.get(0).size() < 8) return;
	    boolean[][] map = new boolean[27][10];
        for(int i = 0 ; i < 9 ; i++)
            for(int j = 0 ; j < 9 ; j++){
                if(board.get(i).get(j) != '.'){
                    int index = board.get(i).get(j) - '0';
                    map[i][index] = map[j+9][index] = map[18+ ((i/3)*3 + j/3)][index] = true;
                }
            }
        sudoku(board,0,0,map);
	}
    
    private boolean sudoku(ArrayList<ArrayList<Character>> board, int i, int j, boolean[][] map){
        if(i == 9 && j == 9){
            return true;
        }
        int[] next = nextItem(i,j);
        if(board.get(i).get(j) == '.'){
            for(int num = 1 ; num < 10 ; num++){
                if(map[i][num] || map[9+j][num] || map[18+ ((i/3)*3 + j/3)][num]) continue;
                board.get(i).set(j,(char)('0' + num));
                map[i][num] = map[9+j][num] = map[18+ ((i/3)*3 + j/3)][num] = true;
                if(sudoku(board,next[0],next[1],map)) 
                    return true;
                map[i][num] = map[9+j][num] = map[18+ ((i/3)*3 + j/3)][num] = false;
                board.get(i).set(j,'.'); // backtracking
            }
        }else{
            return sudoku(board,next[0],next[1],map);
        }
        return false;
    }
    
    private int[] nextItem(int i, int j){
        int[] result = {i,j+1};
        if(i == 8 && j == 8){ 
            result[0] = result[1] = 9;
        }else if(j == 8) {
            result[1] = 0;
            result[0] = i + 1;
        }
        return result;
    }
    
}
