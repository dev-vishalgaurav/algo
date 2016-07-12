/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] map = new boolean[27][10];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                char c = board[i][j];
                if(c!='.'){
                    int index = c - '0';
                    int ik = i, jk = 9 + j, gk = (18 + (i/3)*3 + j/3);
                    if(map[ik][index] || map[jk][index] || map[gk][index]) return false;
                    map[ik][index] = true;
                    map[jk][index] = true;
                    map[gk][index] = true;
                }
            }
        }
        return true;
    }
	/**
	 * using HashMap and HashSet
	 */
	public boolean isValidSudoku(char[][] board) {
        HashMap<String,HashSet<Character>> map = new HashMap<>();
        for(int i = 0 ; i < 9 ; i++){
            map.put("R"+i,new HashSet<Character>());
            map.put("C"+i,new HashSet<Character>());
            map.put("G"+i,new HashSet<Character>());
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                char c = board[i][j];
                if(c!='.'){
                    String rid = "R"+i, cid = "C"+j, gid = "G"+ ((i/3) * 3 + (j/3)) ;
                    if(map.get(rid).contains(c) || map.get(cid).contains(c) || map.get(gid).contains(c)) return false;
                    map.get(rid).add(c);
                    map.get(cid).add(c);
                    map.get(gid).add(c);
                }
            }
        }
        return true;
    }
}