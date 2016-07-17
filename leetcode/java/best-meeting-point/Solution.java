/**
 * https://leetcode.com/problems/best-meeting-point/
 */
public class Solution {
	/**
	 * https://leetcode.com/articles/best-meeting-point/#approach-3-sorting-accepted 
	 */
	public int minTotalDistance(int[][] grid) {
        if(grid.length == 0  || grid[0].length == 0 ) return Integer.MAX_VALUE;
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows) + minDistance1D(cols);
    }
    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }
    private int minDistance1D(List<Integer> points) {
        int distance = 0;
        int i = 0;
        int j = points.size() - 1;
        while (i < j) {
            distance += points.get(j) - points.get(i);
            i++;
            j--;
        }
        return distance;
    }
    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }
    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }
	/**
	 * Accepted (526 ms) Naive Version (O(k N2)) 
	 */
    public int minTotalDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        if(grid.length == 0 || grid[0].length == 0) return min;
        int m = grid.length, n = grid[0].length;
        List<int[]> ones = new ArrayList<>();
        
        for(int i = 0 ; i < m ; i++ )
            for(int j = 0 ; j < n ; j++)
                if(grid[i][j] == 1) ones.add(new int[]{i,j});
        for(int i = 0 ; i < m ; i++ )
            for(int j = 0 ; j < n ; j++){
                int sum = 0;
                for(int[] xy : ones){
                    sum += Math.abs(i - xy[0]) + Math.abs(j - xy[1]);
                }
                min = Math.min(min,sum);
            }
        return min;
    }
}