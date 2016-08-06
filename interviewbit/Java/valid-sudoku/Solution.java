/**
 * https://www.interviewbit.com/problems/valid-sudoku/
 */
public class Solution {
	public int isValidSudoku(final List<String> a) {
	   boolean[][] map = new boolean[27][10];
        for(int i = 0 ; i < a.size() ; i++)
            for(int j = 0 ; j < a.get(0).length() ; j++){
                if(a.get(i).charAt(j) == '.') continue;
                int index = a.get(i).charAt(j) - '0';
                int ik = i, jk = 9 + j, gk = (18 + (i/3)*3 + j/3);
                if(map[ik][index] || map[jk][index] || map[gk][index]) return 0;
                map[ik][index] = map[jk][index] = map[gk][index] = true;
            }
        return 1;
	}
}
