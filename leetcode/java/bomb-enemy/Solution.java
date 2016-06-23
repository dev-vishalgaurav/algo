/**
 *  https://leetcode.com/problems/bomb-enemy/
 */
public class Solution {
    /**
     * Thanks to this solution. https://leetcode.com/discuss/109116/short-o-mn-solution  
     */
    public int maxKilledEnemies(char[][] grid) {
        int max = 0, rowDP = 0;
        if(grid.length > 0 && grid[0].length > 0){
            int[] dpCol = new int[grid[0].length];
            for(int i = 0 ; i < grid.length ; i++){
                for(int j = 0 ; j < grid[0].length ; j++){
                   // restart the dp. which will happen at start or after encountering a 'W'
                   if(j == 0 || grid[i][j-1] == 'W'){
                       rowDP = 0;
                       for(int k = j ; k < grid[0].length && grid[i][k] != 'W'; k++){
                           if(grid[i][k] == 'E') rowDP++ ;
                       }
                   } 
                  // restart the dp. which will happen at start or after encountering a 'W'
                   if(i == 0 || grid[i-1][j] == 'W'){
                       dpCol[j] = 0;
                       for(int k = i ; k < grid.length && grid[k][j] != 'W'; k++){
                           if ( grid[k][j] == 'E' ) dpCol[j]++;
                       } 
                   }
                   if(grid[i][j] == '0'){
                       max = Math.max(max, rowDP + dpCol[j]);
                   }
                }
            }
        }
        return max;   
    }
}