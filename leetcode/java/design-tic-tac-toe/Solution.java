/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 */
public class TicTacToe {
    int[][] playerMap = null;
    int n = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        playerMap = new int[2][2*n + 2]; // rows + columns + diagonals
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int rowIndex = row , colIndex = n + col, diagIndex = 2*n;
        if(++playerMap[player-1][rowIndex] == n) return player;
        if(++playerMap[player-1][colIndex] == n) return player;
        if(row == col && ++playerMap[player-1][diagIndex] == n ) return player;
        if(row + col + 1 == n && ++playerMap[player-1][diagIndex+1] == n ) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */